<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Расчет напряжений</title>
</head>

<body>
			<div class="pic">
				<caption>Расчетная схема</caption>
				<br><br>
				<img src = "pics/4.png"> 
			</div>
<form action="Calculation1" method="GET">

				<input type="hidden" name="command" value="SCHEME4" />
				P, Н :
				<input type="text" name="power" value="${POWER}"/>	
				<br><br>
				l, мм :
				<input type="text" name="length" value="${LENGTH}"/>	
				<br><br>
				k, мм :
				<input type="text" name="leg" value="${LEG}"/>
				<br><br>
				Материал сварного шва :
				<select name="electrode">
					<option>OK Autrod 12.64</option>
					<option>OK Autrod 16.95</option>
				</select>
				<br><br>
				<input type="submit" value="Рассчитать"/>
				<br><br>
				<b>Расчетное напряжение, МПа : ${RESULT} </b>
				<br><br>
				<b>"Запас прочности" : ${MARGIN}</b>
				<br><br>
				<b><h2>${MESSAGE}</h2></b>
					
		</form>
		<p>
			<a href="index.html">На главную</a>
		</p>

</body>

</html>