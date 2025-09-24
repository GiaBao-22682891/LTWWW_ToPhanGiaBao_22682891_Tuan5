<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Nhà cung cấp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9fafb;
            margin: 0;
            padding: 20px;
        }

        .title {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        td:last-child {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="title">
    <h2>Danh sách Nhà cung cấp</h2>
</div>

<a href="view/home.jsp"> Quay trở về </a>
<table>
    <thead>
    <tr>
        <th>Mã NCC</th>
        <th>Tên NCC</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ncc" items="${nccList}">
        <tr>
            <td>${ncc.maNCC}</td>
            <td>${ncc.tenNCC}</td>
            <td>${ncc.diaChi}</td>
            <td>${ncc.soDienThoai}</td>
            <td class="actions">
                <form action="${pageContext.request.contextPath}/dien-thoai-servlet" method="get" style="display:inline">
                    <input type="hidden" name="nccId" value="${ncc.maNCC}">
                    <button type="submit" class="btn btn-view">Xem điện thoại</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
