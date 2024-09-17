package hust.project.moviereservationsystem.constant;

public class EmailTemplate {
    public static final String MOVIE_CREATED_TEMPLATE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>New Movie Notification</title>\n" +
            "    <style>\n" +
            "        body {\n" +
            "            font-family: Arial, sans-serif;\n" +
            "            background-color: #f4f4f4;\n" +
            "            margin: 0;\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .container {\n" +
            "            background-color: #fff;\n" +
            "            padding: 20px;\n" +
            "            border-radius: 10px;\n" +
            "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
            "            max-width: 600px;\n" +
            "            margin: 0 auto;\n" +
            "        }\n" +
            "        .header {\n" +
            "            text-align: center;\n" +
            "            background-color: #007BFF;\n" +
            "            color: #fff;\n" +
            "            padding: 20px;\n" +
            "            border-radius: 10px 10px 0 0;\n" +
            "        }\n" +
            "        .movie-details {\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .movie-title {\n" +
            "            font-size: 24px;\n" +
            "            font-weight: bold;\n" +
            "            color: #333;\n" +
            "        }\n" +
            "        .release-date {\n" +
            "            font-size: 16px;\n" +
            "            color: #666;\n" +
            "        }\n" +
            "        .description {\n" +
            "            margin-top: 10px;\n" +
            "            font-size: 14px;\n" +
            "            color: #555;\n" +
            "        }\n" +
            "        .btn {\n" +
            "            display: inline-block;\n" +
            "            padding: 10px 20px;\n" +
            "            background-color: #28a745;\n" +
            "            color: white;\n" +
            "            text-decoration: none;\n" +
            "            border-radius: 5px;\n" +
            "            margin-top: 20px;\n" +
            "        }\n" +
            "        .footer {\n" +
            "            text-align: center;\n" +
            "            margin-top: 30px;\n" +
            "            font-size: 12px;\n" +
            "            color: #999;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <div class=\"header\">\n" +
            "            <h1>HUY CINEMA - Bộ phim mới!</h1>\n" +
            "        </div>\n" +
            "        <div class=\"movie-details\">\n" +
            "            <h2 class=\"movie-title\">{{params.title}}</h2>\n" +
            "            <p class=\"release-date\">Ngày phát hành: {{params.releaseDate}}</p>\n" +
            "            <p class=\"description\">{{params.description}}</p>\n" +
            "            <a href=\"{{params.movieInfoUrl}}\" class=\"btn\">Xem ngay</a>\n" +
            "        </div>\n" +
            "        <div class=\"footer\">\n" +
            "            <p>Bạn nhận được email này vì đã đăng ký tại HUY CINEMA. Nếu không muốn nhận thêm thông báo, <a href=\"#\">hủy đăng ký</a>.</p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>\n";

    public static final String PAYMENT_COMPLETED_TEMPLATE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Payment Confirmation</title>\n" +
            "    <style>\n" +
            "        body {\n" +
            "            font-family: Arial, sans-serif;\n" +
            "            background-color: #f4f4f4;\n" +
            "            margin: 0;\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .container {\n" +
            "            background-color: #fff;\n" +
            "            padding: 20px;\n" +
            "            border-radius: 10px;\n" +
            "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
            "            max-width: 600px;\n" +
            "            margin: 0 auto;\n" +
            "        }\n" +
            "        .header {\n" +
            "            text-align: center;\n" +
            "            background-color: #28a745;\n" +
            "            color: #fff;\n" +
            "            padding: 20px;\n" +
            "            border-radius: 10px 10px 0 0;\n" +
            "        }\n" +
            "        .header h1 {\n" +
            "            margin: 0;\n" +
            "            font-size: 24px;\n" +
            "        }\n" +
            "        .content {\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .content h2 {\n" +
            "            font-size: 20px;\n" +
            "            color: #333;\n" +
            "        }\n" +
            "        .content p {\n" +
            "            font-size: 16px;\n" +
            "            color: #555;\n" +
            "        }\n" +
            "        .ticket-info {\n" +
            "            background-color: #f9f9f9;\n" +
            "            padding: 15px;\n" +
            "            border-radius: 8px;\n" +
            "            margin-top: 20px;\n" +
            "        }\n" +
            "        .ticket-info p {\n" +
            "            margin: 5px 0;\n" +
            "        }\n" +
            "        .btn {\n" +
            "            display: inline-block;\n" +
            "            padding: 10px 20px;\n" +
            "            background-color: #007BFF;\n" +
            "            color: white;\n" +
            "            text-decoration: none;\n" +
            "            border-radius: 5px;\n" +
            "            margin-top: 20px;\n" +
            "        }\n" +
            "        .footer {\n" +
            "            text-align: center;\n" +
            "            margin-top: 30px;\n" +
            "            font-size: 12px;\n" +
            "            color: #999;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <div class=\"header\">\n" +
            "            <h1>Xác nhận thanh toán thành công</h1>\n" +
            "        </div>\n" +
            "        <div class=\"content\">\n" +
            "            <h2>Xin chào [Tên Khách Hàng],</h2>\n" +
            "            <p>Cảm ơn bạn đã đặt vé tại [Tên Rạp]. Dưới đây là thông tin vé của bạn:</p>\n" +
            "            <div class=\"ticket-info\">\n" +
            "                <p><strong>Bộ phim:</strong> [Tên Bộ Phim]</p>\n" +
            "                <p><strong>Rạp chiếu:</strong> [Tên Rạp]</p>\n" +
            "                <p><strong>Ngày chiếu:</strong> [Ngày Chiếu]</p>\n" +
            "                <p><strong>Giờ chiếu:</strong> [Giờ Chiếu]</p>\n" +
            "                <p><strong>Vị trí ghế:</strong> [Số Ghế]</p>\n" +
            "                <p><strong>Mã vé:</strong> [Mã Vé]</p>\n" +
            "            </div>\n" +
            "            <a href=\"[Link Xem Chi Tiết]\" class=\"btn\">Xem chi tiết vé</a>\n" +
            "        </div>\n" +
            "        <div class=\"footer\">\n" +
            "            <p>Bạn nhận được email này vì đã đặt vé tại [Tên Rạp]. Nếu có bất kỳ câu hỏi nào, vui lòng liên hệ với chúng tôi.</p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>\n";
}
