# Convert object to json

Supporting types:
- String
- int
- ArrayList
- String[]
- Integer[]

Usage:
```sh
  toJSON(Object o, Boolean format);
```

App execution:
```sh
mvn exec:java
````

Example result:
```sh
{
	"name": "Piotr",
	"indx": "195019",
	"tab_str": [
		"A",
		"B"
	],
	"tab_int": [
		"1",
		"2"
	],
	"list_str": [
		"A",
		"B"
	],
	"list_int": [
		"1",
		"2"
	]
}
```
