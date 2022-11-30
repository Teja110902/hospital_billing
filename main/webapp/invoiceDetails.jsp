<%--
  Created by IntelliJ IDEA.
  User: cloudray
  Date: 30/04/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Invoice</title>
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
    <table id="invoiceTable" width="100%">
        <tr>
            <td><b>Invoice Number: </b> INV/<s:property value="invoice.invoiceNumber"></s:property> </td>
            <td> <b>Patient Name: </b> <s:property value="invoice.patientName"></s:property> </td>
            <td><b>Invoice Date: </b> <s:property value="invoice.invoiceDate"></s:property> </td>
        </tr>
        <tr>
            <td><b>Amount(INR): </b> <s:property value="invoice.totalAmount"></s:property> </td>
            <td><b>Status: </b> <s:property value="invoice.billingStatus"></s:property> </td>
        </tr>
        <tr>
            <table id="lineItem" width="100%">
                <thead>
                    <th>Charge Name</th>
                    <th>Description</th>
                    <th>Qty</th>
                    <th>Unit Price</th>
                    <th>Total Amount</th>
                </thead>
                <tbody>
                <s:iterator value="invoice.lineItems">
                    <tr>
                        <td>
                            <s:property value="chargeID"></s:property>
                        </td>
                        <td>
                            <s:property value="description"></s:property>
                        </td>
                        <td>
                            <s:property value="qty"></s:property>
                        </td>
                        <td>
                            <s:property value="rate"></s:property>
                        </td>
                        <td>
                            <s:property value="totalAmount"></s:property>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </tr>
    </table>
</body>
</html>
