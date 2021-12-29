double value = .012;
double pSum = value + value + value;
String strValue = Double.toString(value);
BigDecimal bigValue = new BigDecimal(strValue);
BigDecimal bSum = bigValue.add(bigValue).add(bigValue);
double sum = bSum.doubleValue();