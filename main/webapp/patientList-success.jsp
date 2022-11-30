<%--
  Created by IntelliJ IDEA.
  User: cloudray
  Date: 29/04/2022
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Patient List</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    <style>
        body{
            font-family: 'Roboto';
        }
        table{
            border: 1px solid darkolivegreen;
        }
        th{
            background: darkolivegreen;
            color: white;
        }
        td{
            padding: 3px;
        }
    </style>
</head>
<body>
<table width="100%">
    <thead>
    <th>Patient ID</th>
    <th>Patient Name</th>
    <th>Patient Type</th>
    <th>Age</th>
    <th>Sex</th>
    <th>Mobile</th>
    <th>Email</th>
    </thead>
    <tbody>
    <s:iterator value="patientList">
        <tr>
            <td>
                <s:property value="patientID"></s:property>
            </td>
            <td>
                <s:url action="patientDetails.action" var="patientURL">
                    <s:param name="patientID">
                        <s:property value="patientID"></s:property>
                    </s:param>
                </s:url>
                <a href="<s:property value="#patientURL" />" ><s:property value="patientName"/></a>

            </td>
            <td>
                <s:property value="patientType"></s:property>
            </td>
            <td>
                <s:property value="patientAge"></s:property>
            </td>
            <td>
                <s:property value="patientSex"></s:property>
            </td>
            <td>
                <s:property value="patientContactNum"></s:property>
            </td>
            <td>
                <s:property value="patientEmailID"></s:property>
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>
