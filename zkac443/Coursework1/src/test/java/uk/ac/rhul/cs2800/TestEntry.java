package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test class for the {@link Entry} class to ensure its functionality.
 */
public class TestEntry {

  /**
   * Tests the equality of two {@link Entry} objects with the same float value.
   */
  //test 1
  @Test
  public void testFloatEntryEquality() {
    Entry entry1 = new Entry(20.0f);
    Entry entry2 = new Entry(20.0f);
    assertEquals(entry1, entry2);
    assertEquals(entry1.getValue(), 20.0f);
    assertEquals(entry1.getType(), Type.NUMBER);
  }

  /**
   * Tests the equality of two {@link Entry} objects with empty strings.
   */
  // test 2
  @Test
  public void testStringEntryEquality() {
    Entry entry1 = new Entry("");
    Entry entry2 = new Entry("");
    assertEquals(entry1, entry2);
    assertEquals(entry1.getString(), "");
    assertEquals(entry1.getType(), Type.STRING);
  }

  /**
   * Tests the equality of two {@link Entry} objects with the same symbol.
   */
  //test 3
  @Test
  public void testSymbolEntryEquality() {
    Entry entry1 = new Entry(Symbol.DIVIDE);
    Entry entry2 = new Entry(Symbol.DIVIDE);
    assertEquals(entry1, entry2);
    assertEquals(entry1.getSymbol(), Symbol.DIVIDE);
    assertEquals(entry1.getType(), Type.SYMBOL);
  }

  /**
   * Tests that entries of different types are not equal.
   */
  //test 4
  @Test
  public void testDifferentTypeEntriesNotEqual() {
    Entry numberEntry = new Entry(30.0f);
    Entry stringEntry = new Entry("James");
    Entry symbolEntry = new Entry(Symbol.PLUS);

    assertNotEquals(numberEntry, stringEntry);
    assertNotEquals(numberEntry, symbolEntry);
    assertNotEquals(stringEntry, symbolEntry);
  }

  /**
   * Tests the hashCode of two equal {@link Entry} objects.
   */
  //test 5
  @Test
  public void testHashCode() {
    Entry entry1 = new Entry(12.0f);
    Entry entry2 = new Entry(12.0f);
    assertEquals(entry1.hashCode(), entry2.hashCode());
  }

  /**
   * Tests that calling {@link Entry#getSymbol()} on an entry of the wrong type throws a
   * {@link BadTypeException}.
   */
  //test 6
  @Test
  public void testGetSymbolBadType() {
    Entry entry = new Entry(45.0f);
    assertThrows(BadTypeException.class, () -> entry.getSymbol());
  }

  /**
   * Tests that calling {@link Entry#getString()} on an entry of the wrong type throws a
   * {@link BadTypeException}.
   */
  //test 7
  @Test
  public void testGetStringBadType() {
    Entry entry = new Entry(Symbol.MINUS);
    assertThrows(BadTypeException.class, () -> entry.getString());
  }

  /**
   * Tests that calling {@link Entry#getValue()} on an entry of the wrong type throws a
   * {@link BadTypeException}.
   */
  //test 8
  @Test
  public void testGetValueBadType() {
    Entry entry = new Entry("");
    assertThrows(BadTypeException.class, () -> entry.getValue());
  }

  /**
   * Tests that two {@link Entry} objects with different float values are not equal.
   */
  //test 9
  @Test
  public void testNotEqualFloatEntryEquality() {
    Entry entry1 = new Entry(40.0f);
    Entry entry2 = new Entry(50.0f); // Different value
    assertNotEquals(entry1, entry2);
  }

  /**
   * Tests that two {@link Entry} objects with different strings are not equal.
   */
  //test 10
  @Test
  public void testNotEqualStringEntryEquality() {
    Entry entry1 = new Entry("James");
    Entry entry2 = new Entry("Jack"); // Different string
    assertNotEquals(entry1, entry2);
  }

  /**
   * Tests that two {@link Entry} objects with different symbols are not equal.
   */
  //test 11
  @Test
  public void testNotEqualSymbolEntryEquality() {
    Entry entry1 = new Entry(Symbol.DIVIDE);
    Entry entry2 = new Entry(Symbol.MINUS); // Different symbol
    assertNotEquals(entry1, entry2);
  }

  /**
   * Tests that an {@link Entry} object is not equal to null.
   */
  //test 12
  @Test
  void testNull() {
    Entry entry = new Entry(1.0f);
    assertNotEquals(entry, null);
  }

  /**
   * Tests that an {@link Entry} object is not equal to an object of a different class.
   */
  //test 13
  @Test
  public void testDifferentClassEntriesNotEqual() {
    Entry numberEntry = new Entry(71.0f);
    Object differentClassEntry = new Object();
    assertNotEquals(numberEntry, differentClassEntry);
  }
}
