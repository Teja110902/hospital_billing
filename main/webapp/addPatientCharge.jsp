<%--
  Created by IntelliJ IDEA.
  User: cloudray
  Date: 29/04/2022
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Patient Charges List</title>
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
    <s:form action="savePatientCharge">
        <table width="50%">
            <thead>
            <th colspan="2">Add Patient Charge</th>
            </thead>
            <tr>
                <td>
                    <s:select list="charges" name="chargeForm.chargeID" listKey="chargeID" listValue="chargeType" label="Select Charge"></s:select>

                </td>
            </tr>
            <tr>
                <td>
                    <s:textfield type="date" name="chargeForm.chargeDate" label="Charge Date"></s:textfield>
                    <s:hidden name="chargeForm.patientID" value="%{patientID}"></s:hidden>

                </td>
            </tr>
            <tr>
                <td>
                    <s:submit name="save" value="save"></s:submit>

                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
