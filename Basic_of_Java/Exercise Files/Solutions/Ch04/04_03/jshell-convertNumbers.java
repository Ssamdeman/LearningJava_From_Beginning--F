int result = 10 + 12;
String answer = "The answer is " + result;
String howMany = 20 + " things";
int intValue = 42;
String fromInt = Integer.toString(intValue);
boolean boolValue = true;
String fromBool = Boolean.toString(boolValue);
long longValue = 10_000_000;
String fromLong = Long.toString(longValue);
String.format("Shirt size: %s, Qty: %d", "M", 4)
int qty = 5;
String size = "M";
String.format("Shirt size: %s, Qty: %d", size, qty)