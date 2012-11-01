<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Conduct bøker</title>
</head>
<body>
 
<h1>Conduct bøker</h1>
<s:actionerror/>
 
<s:form action="add" method="post">
    <s:textfield name="book.title" label="Tittel"/>
    <s:textfield name="book.firstName" label="Forfatter Etternavn"/>
    <s:textfield name="book.lastName" label="Forfatter Fornavn"/>
    <s:textfield name="book.created" label="Lagt til"/>

    <s:submit value="Legg til bok" align="center"/>
</s:form>
 
 
<h2>Bøker</h2>
<table border="1">
<tr>
    <th>Tittel</th>
    <th>Etternavn</th>
    <th>Fornavn</th>
    <th>Lagt til</th>
    <th></th>
</tr>
<s:iterator value="bookList" var="book">
    <tr>
        <td><s:property value="title"/></td>
        <td><s:property value="lastName"/><td>
        <td><s:property value="firstName"/></td>
        <td><s:property value="created"/></td>
        <td><a href="delete?id=<s:property value="id"/>">Slett</a></td>
    </tr> 
</s:iterator>
</table>
</body>
</html>