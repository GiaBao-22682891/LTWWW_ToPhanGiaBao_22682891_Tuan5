<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm điện thoại mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            margin-top: 15px;
            width: 100%;
            padding: 10px;
            background: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #0056b3;
        }

        .back {
            display: block;
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Thêm điện thoại mới</h2>
    <form action="${pageContext.request.contextPath}/them-san-pham-servlet" method="post">
        <label for="tenDT">Tên điện thoại</label>
        <input type="text" id="tenDT" name="tenDT" required>

        <label for="cauHinh">Cấu hình</label>
        <input type="text" id="cauHinh" name="cauHinh">

        <label for="namSX">Năm sản xuất</label>
        <input type="number" id="namSX" name="namSX" required>

        <label for="hinhAnh">Tên file hình ảnh</label>
        <input type="text" id="hinhAnh" name="hinhAnh" placeholder="vd: iphone15.png">

        <label for="nccId">Nhà cung cấp</label>
        <select id="nccId" name="nccId">
            <c:forEach var="ncc" items="${nccList}">
                <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
            </c:forEach>
        </select>

<%--        <label for="nccId">NCC</label>--%>
<%--        <input type="number" id="nccId" name="nccId" required>--%>

        <button type="submit" name="action" value="create">Thêm mới</button>
    </form>
    <a class="back" href="${pageContext.request.contextPath}/nha-cung-cap-servlet">← Quay lại danh sách</a>
</div>
</body>
</html>
