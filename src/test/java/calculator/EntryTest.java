package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * JUnit test case for {@link calculator.Entry}.
 * 
 * @author wjis132
 */
public class EntryTest {

  @Test
  public void testEquals() {
    // First set of test entries (float, symbol, string types)
    Entry testEntryFloat1 = new Entry(3.14f);
    Entry testEntrySymbol1 = new Entry(Symbol.PLUS);
    Entry testEntryStr1 = new Entry("420");

    // comparing the same entry should be equal
    assertEquals(testEntryFloat1, testEntryFloat1);
    assertEquals(testEntrySymbol1, testEntrySymbol1);
    assertEquals(testEntryStr1, testEntryStr1);

    // comparing different type entry should not be equal
    assertNotEquals(testEntryFloat1, testEntrySymbol1);
    assertNotEquals(testEntryFloat1, testEntryStr1);
    assertNotEquals(testEntrySymbol1, testEntryStr1);

    // Second set of test entries (float, symbol, string types)
    Entry testEntryFloat2 = new Entry(3.14f);
    Entry testEntrySymbol2 = new Entry(Symbol.PLUS);
    Entry testEntryStr2 = new Entry("420");

    // comparing two entries with same value should be equal
    assertEquals(testEntryFloat1, testEntryFloat2);
    assertEquals(testEntrySymbol1, testEntrySymbol2);
    assertEquals(testEntryStr1, testEntryStr2);

    // Third set of test entries (float, symbol, string types)
    Entry testEntryFloat3 = new Entry(3.15f);
    Entry testEntrySymbol3 = new Entry(Symbol.MINUS);
    Entry testEntryStr3 = new Entry("421");

    // comparing same type but different value entry should not be equal
    assertNotEquals(testEntryFloat1, testEntryFloat3);
    assertNotEquals(testEntrySymbol1, testEntrySymbol3);
    assertNotEquals(testEntryStr1, testEntryStr3);

    // Set of invalid entries
    Entry testEntryInvalid1 = new Entry();
    Entry testEntryInvalid2 = new Entry();

    // invalid entries should not be equal
    assertNotEquals(testEntryInvalid1, testEntryInvalid2);

  }

  /**
   * Test method for {@link calculator.Entry#hashCode()}.
   */
  @Test
  public void testHashCode() {
    // create two test entries with the same value 3.14f
    Entry testEntryFloat1 = new Entry(3.14f);
    Entry testEntryFloat2 = new Entry(3.14f);

    // calling hashCode() on both entries should return the same hash code
    assertEquals(testEntryFloat1.hashCode(), testEntryFloat2.hashCode());

    // create two test entries with the same enum Symbol.PLUS
    Entry testEntrySymbol1 = new Entry(Symbol.PLUS);
    Entry testEntrySymbol2 = new Entry(Symbol.PLUS);

    // calling hashCode() on both entries should return the same hash code
    assertEquals(testEntrySymbol1.hashCode(), testEntrySymbol2.hashCode());

    // create two test entries with the same string "420"
    Entry testEntryStr1 = new Entry("420");
    Entry testEntryStr2 = new Entry("420");

    // calling hashCode() on both entries should return the same hash code
    assertEquals(testEntryStr1.hashCode(), testEntryStr2.hashCode());
  }

  /**
   * Test method for {@link calculator.Entry#getType()}.
   */
  @Test
  public void testGetType() {
    // create entry with float value 3.14f
    Entry testEntryFloat = new Entry(3.14f);
    // type of float entry should be Type.NUMBER
    assertEquals(Type.NUMBER, testEntryFloat.getType());

    // create entry with Symbol.PLUS
    Entry testEntrySymbol = new Entry(Symbol.PLUS);
    // type of Symbol entry should be Type.SYMBOL
    assertEquals(Type.SYMBOL, testEntrySymbol.getType());

    // create entry with string value
    Entry testEntryString = new Entry("420");
    // type of Symbol entry should be Type.STRING
    assertEquals(Type.STRING, testEntryString.getType());

    // create entry with no arguments
    Entry testEntryInvalid = new Entry();
    // invalid entry should be created, type of entry should be Type.INVALID
    assertEquals(Type.INVALID, testEntryInvalid.getType());
  }

  /**
   * Test method for {@link calculator.Entry#getString()}.
   */
  @Test
  public void testGetString() {

    // create entry with type string
    Entry testEntryString = new Entry("420");

    // calling getString() on a string type entry should return expected original value
    try {
      assertEquals("420", testEntryString.getString());
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test method for {@link calculator.Entry#getSymbol()}.
   */
  @Test
  public void testGetSymbol() {
    Entry testEntrySymbol = new Entry(Symbol.PLUS);
    try {
      assertEquals(Symbol.PLUS, testEntrySymbol.getSymbol());
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test method for {@link calculator.Entry#getValue()}.
   */
  @Test
  public void testGetValue() {
    Entry testEntryFloat = new Entry(3.14f);
    try {
      assertEquals(3.14f, testEntryFloat.getValue(), 0.0f);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test method for {@link calculatorBadTypeException} being thrown.
   */
  @Test
  public void testGetBadType() {
    // create entry with type number
    Entry testEntryFloat = new Entry(3.14f);
    // get symbol and string from a number entry should throw BadTypeExceptions
    assertThrows(BadTypeException.class, () -> {
      testEntryFloat.getSymbol();
    });
    assertThrows(BadTypeException.class, () -> {
      testEntryFloat.getString();
    });

    // create entry with type Symbol
    Entry testEntrySymbol = new Entry(Symbol.PLUS);
    // get value and string from a symbol entry should throw BadTypeExceptions
    assertThrows(BadTypeException.class, () -> {
      testEntrySymbol.getValue();
    });
    assertThrows(BadTypeException.class, () -> {
      testEntrySymbol.getString();
    });

    // create entry with type string
    Entry testEntryString = new Entry("420");
    // get value and symbol from a string entry should throw BadTypeExceptions
    assertThrows(BadTypeException.class, () -> {
      testEntryString.getValue();
    });
    assertThrows(BadTypeException.class, () -> {
      testEntryString.getSymbol();
    });
  }

  /**
   * Test method for {@link calculator.Entry#toString()}
   */
  @Test
  public void testToString() {
    // create entry with float value 3.14f
    Entry testEntryFloat = new Entry(3.14f);
    // entry toString() should be 3.14
    assertEquals("3.14", testEntryFloat.toString());

    // create entry with Symbol.PLUS
    Entry testEntrySymbol = new Entry(Symbol.PLUS);
    // entry toString() should be + (string representation of Symbol.PLUS)
    assertEquals("+", testEntrySymbol.toString());

    // create entry with string value
    Entry testEntryString = new Entry("420");
    // entry toString() should be 420
    assertEquals("420", testEntryString.toString());

    // create entry with no arguments
    Entry testEntryInvalid = new Entry();
    // entry toString() should return invalid
    assertEquals("invalid", testEntryInvalid.toString());
  }

}
