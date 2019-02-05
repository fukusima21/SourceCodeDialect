# SourceCodeDialect
Original Thymeleaf Dialect for embed source code

Current version: 

 * **Version 0.1.0-SNAPSHOT

Maven info
----------

  *   groupId: `org.netf.otd.source-code-dialect`   
  *   artifactId: `SourceCodeDialect`
  
# usage
```html:sample
<html xmlns:th="http://www.thymeleaf.org"  
	xmlns:source-code="http://www.netf.org/thymeleaf/source-code-dialect">
	<pre>
		<code source-code:path="/path/to/source-code"> - source code - </code>
	</pre>
```
