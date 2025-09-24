<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách điện thoại</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: center; }
        th { background: #007BFF; color: white; }
        tr:nth-child(even) { background: #f9f9f9; }
        img { max-width: 80px; border-radius: 5px; }
    </style>
</head>
<body>
<h2>Danh sách điện thoại</h2>
<table>
    <thead>
    <tr>
        <th>Mã điện thoại</th>
        <th>Tên điện thoại</th>
        <th>Cấu hình</th>
        <th>Năm sản xuất</th>
        <th>Hình ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dt" items="${dienThoaiList}">
        <tr>
            <td>${dt.maDT}</td>
            <td value = "tendt">${dt.tenDT}</td>
            <td>${dt.cauHinh}</td>
            <td>${dt.namSX}</td>
            <td>
                <c:if test="${not empty dt.hinhAnh}">
                    <img src="images/${dt.hinhAnh}" alt="${dt.tenDT}">
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="nha-cung-cap-list.jsp">← Quay lại danh sách nhà cung cấp</a>
</body>
</html>
