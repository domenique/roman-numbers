import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumbersTest {

  @Test
  public void returnsI() {
    assertThat(toRoman(1), is("I"));
  }

  @Test
  public void returnsII() {
    assertThat(toRoman(2), is("II"));
  }

  @Test
  public void returnsIII() {
    assertThat(toRoman(3), is("III"));
  }

  @Test
  public void returnsIV() {
    assertThat(toRoman(4), is("IV"));
  }

  @Test
  public void returnsV() {
    assertThat(toRoman(5), is("V"));
  }

  @Test
  public void returnsVI() {
    assertThat(toRoman(6), is("VI"));
    assertThat(toRoman(7), is("VII"));
    assertThat(toRoman(8), is("VIII"));
  }

  @Test
  public void returnsIX() {
    assertThat(toRoman(9), is("IX"));
  }

  @Test
  public void returnsX() {
    assertThat(toRoman(10), is("X"));
  }

  @Test
  public void returnsXI() {
    assertThat(toRoman(11), is("XI"));
  }

  @Test
  public void returnsSpecials() {
    assertThat(toRoman(14), is("XIV"));
    assertThat(toRoman(15), is("XV"));
    assertThat(toRoman(19), is("XIX"));
    assertThat(toRoman(39), is("XXXIX"));
  }

  @Test
  public void returnsXL() {
    assertThat(toRoman(40), is("XL"));
    assertThat(toRoman(44), is("XLIV"));
    assertThat(toRoman(49), is("XLIX"));
  }

  @Test
  public void returnsL() {
    assertThat(toRoman(50), is("L"));
  }

  @Test
  public void returnsWhatever() {
    assertThat(toRoman(0), is(""));
  }

  private String toRoman(int number) {
    Map<Integer, String> lookup = new LinkedHashMap<>();
    lookup.put(50, "L");
    lookup.put(40, "XL");
    lookup.put(10, "X");
    lookup.put(9, "IX");
    lookup.put(5, "V");
    lookup.put(4, "IV");
    lookup.put(1, "I");

    if (lookup.containsKey(number)) {
      return lookup.get(number);
    }

//    Map<Integer, Integer> intervals = Set.of(5,10);
//    if(intervals.contains(number) && number > intervals.get(number)) {
//      return toRoman(number) + toRoman(intervals.get(number) - number);
//    }

    for (int current : lookup.keySet()) {
      if (number > current) {
        return toRoman(current) + toRoman(number - current);
      }
    }
    return "";
  }
}





