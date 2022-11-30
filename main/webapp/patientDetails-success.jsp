<%--
  Created by IntelliJ IDEA.
  User: cloudray
  Date: 30/04/2022
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Patient Details</title>
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
    <div>
        <table width="100%">
            <thead>
            <th>Patient ID</th>
            <th>Patient Name</th>
            <th>Patient Type</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Address Line 1</th>
            <th>Address Line 2</th>
            <th>Pincode</th>
            <th>State</th>
            <th>Country</th>
            <th>Mobile</th>
            <th>Email</th>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <s:property value="patientDetails.patientID"></s:property>
                    </td>

                    <td>
                        <s:property value="patientDetails.patientName"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientType"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientAge"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientSex"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientAddressLine1"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientAddressLine2"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientPincode"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientState"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientCountry"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientContactNo"></s:property>
                    </td>
                    <td>
                        <s:property value="patientDetails.patientEmailID"></s:property>
                    </td>
                </tr>
            </tbody>
        </table>

    </div>
    <br/>
    <br/>
    <div>
        <!-- patient charges -->
        <table width="100%">
            <thead>
            <th>Patient Charge ID</th>
            <th>Patient ID</th>
            <th>Charge ID</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Charge Date</th>
            </thead>
            <tbody>
            <s:iterator value="patientCharges">
                <tr>
                    <td>
                        <s:property value="patientChargeID"></s:property>
                    </td>
                    <td>
                        <s:property value="patientID"></s:property>
                    </td>
                    <td>
                        <s:property value="chargeID"></s:property>
                    </td>
                    <td>
                        <s:property value="amount"></s:property>
                    </td>
                    <td>
                        <s:property value="description"></s:property>
                    </td>
                    <td>
                        <s:property value="chargeDate"></s:property>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <br>
        <s:url action="createInvoice.action" var="invoiceURL">
            <s:param name="patientID">
                <s:property value="patientID"></s:property>
            </s:param>
        </s:url>
        <button> <a href="<s:property value="#invoiceURL" />"> Generate Invoice </a> </button>

        <s:url action="addPatientCharges.action" var="patientChargesURL">
            <s:param name="patientID">
                <s:property value="patientID"></s:property>
            </s:param>
        </s:url>
        <button> <a href="<s:property value="#patientChargesURL" />"> Add Patient Charge </a> </button>

    </div>

</body>
</html>
