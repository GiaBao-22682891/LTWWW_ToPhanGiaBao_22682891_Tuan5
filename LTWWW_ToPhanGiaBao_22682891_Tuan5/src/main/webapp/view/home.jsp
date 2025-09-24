<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        .container {
            border: solid black 1px;
            margin: 10px;
        }

        .header {
            width: 100%;
            height: 300px;

        }
        .navbar {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 20px ;
            border: solid 1px black;
        }

        .navbar a {
            font-family: "Times New Roman";
            font-size: 18px;
        }

        .content {
            height: 200px;
        }

        .footer {
            border: solid 1px black;
            align-items: center;
            justify-content: center;
            display: flex;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <img src="../Images/header.png">
    </div>
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/nha-cung-cap-servlet">Danh sách nhà cung cấp</a>
        |
        <a href="">Thêm mới sản phẩm</a>
        |
        <a href="">Chức năng quản lý</a>
    </div>
    <div class="content">

    </div>

    <div class="footer">
        <p>
            Tô Phan Gia Bảo - 22682891 - DHKTPM18ATT
        </p>
    </div>

</div>

</body>
</html>