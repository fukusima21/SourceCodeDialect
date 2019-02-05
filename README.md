# SourceCodeDialect
Original Thymeleaf Dialect for embed source code  
Escape the contents of the specified file.  

# escape charactor

|  TH  |  TH  |
| ---- | ---- |
|  TD  |  TD  |
|  TD  |  TD  |

|  TH  |  TH  |
| --- | -------- |--------------- |
|  "  |  &quot;  |  double-quote  |
|  &  |  &amp;   |  ampersand     |
|  <  |  &lt;    |  less-than     |
|  >  |  &gt;    |  greater-than  |


Current version: 
 
 * **Version 0.1.0-SNAPSHOT**

Maven info
----------

  *   groupId: `org.netf.otd.source-code-dialect`   
  *   artifactId: `SourceCodeDialect`

Installation
------------

Just add the `import org.netf.otd.source_code_dialect.dialect.SourceCodeDialect;`
class to the list of dialects in your TemplateEngine implementation, and you will
have the `source-code` attribute available to be used in your templates.

```java
TemplateEngine templateEngine = new TemplateEngine();
templateEngine.addDialect(new SourceCodeDialect());
...
```

# usage
```html:sample
<html xmlns:th="http://www.thymeleaf.org"  
	xmlns:source-code="http://www.netf.org/thymeleaf/source-code-dialect">
	<pre>
		<code source-code:path="/path/to/source-code"> - source code - </code>
	</pre>

	<pre>
		<code source-code:encode="shift_jis" source-code:path="/path/to/source-code"> - source code - </code>
	</pre>

```



