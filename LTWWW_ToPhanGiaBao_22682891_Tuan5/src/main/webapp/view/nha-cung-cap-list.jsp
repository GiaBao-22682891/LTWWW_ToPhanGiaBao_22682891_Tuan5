<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/18/2025
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td {padding:10px; border-bottom:1px solid black}
    </style>
</head>
<body>

    <div style="display: flex; flex-direction: column; justify-content: center; text-align: center; border: solid black 1px">
        <div>
            Danh sach nha cung cap
        </div>
    </div>
    <table>
        <thead>
            <tr style="border-bottom: solid black 1px; display:flex">
                <th>
                    Ma NCC
                </th>
                <th>
                    Ten NCC
                </th>
                <th>
                    Dia chi
                </th>
                <th>
                    So dien thoai
                </th>
                <th>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ncc" items="${nccList}" varStatus="s">
                <tr style="display: flex">
                    <td>${ncc.maNCC}</td>
                    <td>${ncc.tenNCC}</td>
                    <td>${ncc.diaChi}</td>
                    <td>${ncc.soDienThoai}</td>

                </tr>
            </c:forEach>

        </tbody>
    </table>

</body>
</html>
