<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Профессии</title>
    <meta charset="utf-8"/>
    <style type="text/css">
        .header {
            display:flex;
            justify-content:center;
        }
        .content {
            width:100%;
            display:flex;
            justify-content:center;
            flex-wrap: wrap;
        }
        .leftblock {
            flex-grow:1;
        }
        .centerblock {
            flex-grow:8;
        }
        .rigthblock {
            flex-grow:1;
        }
        .footer {
            display:flex;
            justify-content:center;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Поиск профессии</h1>
</div>
<div class="content">
    <div class="leftblock"></div>
    <div class="centerblock">
        <div>
            <form action="/profession" method="post">
                <input id="name" name="name" type="text" value="${name!}">
                <input type="submit" value="Искать ">
            </form>
        </div>
        <table>
            <#list professions as prof>
                <tr>
                    <td>${prof.id}</td>
                    <td>${prof.name}</td>
                </tr>
            </#list>
        </table>
    </div>
    <div class="rigthblock"></div>
</div> <!-- content -->
<div class="footer">
    <div id="">
        <#list countPages as n>
            <span>
                <a href="/profession?page=${n}&name=${name!}">${n}&nbsp;</a>
            </span>
        </#list>
    </div>
    <div>&copy;ИТИС</div>
</div>
</body>
</html>