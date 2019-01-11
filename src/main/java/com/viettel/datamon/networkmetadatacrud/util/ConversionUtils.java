package com.viettel.datamon.networkmetadatacrud.util;

public class ConversionUtils {


  public static boolean isNumericType(Class clz) {
    return clz == Long.class
        || clz == Integer.class
        || clz == Short.class
        || clz == Byte.class
        || clz == Double.class
        || clz == Float.class;
  }

  public static Object stringToDecimal(Class decimalClass, String stringValue) {
    if (decimalClass == Long.class) {
      return Long.parseLong(stringValue);
    } else if (decimalClass == Integer.class) {
      return Integer.parseInt(stringValue);
    } else if (decimalClass == Short.class) {
      return Short.parseShort(stringValue);
    } else if (decimalClass == Byte.class) {
      return Byte.parseByte(stringValue);
    } else if (decimalClass == Double.class) {
      return Double.parseDouble(stringValue);
    } else if (decimalClass == Float.class) {
      return Float.parseFloat(stringValue);
    } else {
      throw new UnsupportedOperationException(
          "No conversion support for class " + decimalClass.getName());
    }
  }
}
