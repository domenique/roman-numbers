
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class RomanNumbersTest {

  private static final Map<Integer, String> LOOKUP = new LinkedHashMap<>() {{
    put(50, "L");
    put(40, "XL");
    put(10, "X");
    put(9, "IX");
    put(5, "V");
    put(4, "IV");
    put(1, "I");
  }};

  @DisplayName("Roman Literals")
  @ParameterizedTest(name = "The roman literal representation of \"{0}\" should be {1}")
  @MethodSource("parameters")
  void inputShouldResultIn(int input, String result) {
    assertThat(toRoman(input)).isEqualTo(result);
  }

  private static Stream<Arguments> parameters() {
    return Stream.of(
        Arguments.of(1, "I"),
        Arguments.of(2, "II"),
        Arguments.of(3, "III"),
        Arguments.of(4, "IV"),
        Arguments.of(5, "V"),
        Arguments.of(6, "VI"),
        Arguments.of(7, "VII"),
        Arguments.of(8, "VIII"),
        Arguments.of(9, "IX"),
        Arguments.of(10, "X"),
        Arguments.of(11, "XI"),
        Arguments.of(14, "XIV"),
        Arguments.of(15, "XV"),
        Arguments.of(19, "XIX"),
        Arguments.of(39, "XXXIX"),
        Arguments.of(40, "XL"),
        Arguments.of(44, "XLIV"),
        Arguments.of(49, "XLIX"),
        Arguments.of(50, "L"));
  }

  private String toRoman(int number) {
    if (LOOKUP.containsKey(number)) {
      return LOOKUP.get(number);
    }

    for (int current : LOOKUP.keySet()) {
      if (number > current) {
        return toRoman(current) + toRoman(number - current);
      }
    }
    return "";
  }
}





