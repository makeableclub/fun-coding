Map<Integer, String> map = new HashMap<>();
map.put(1, "linode.com");
map.put(2, "heroku.com");

//Map -> Stream -> Filter -> String
String result = map.entrySet().stream()
    .filter(x -> "something".equals(x.getValue()))
    .map(x->x.getValue())
    .collect(Collectors.joining());

//Map -> Stream -> Filter -> MAP
Map<Integer, String> collect = map.entrySet().stream()
    .filter(x -> x.getKey() == 2)
    .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

// or like this
Map<Integer, String> collect = map.entrySet().stream()
    .filter(x -> x.getKey() == 3)
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
