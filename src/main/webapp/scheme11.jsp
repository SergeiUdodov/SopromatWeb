<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style-schemes.css">
	<title>Расчет напряжений</title>
	
</head>

<body>
<div  class="flex-container w3-center">
	<b><h2 class="w3-text-orange" style="text-shadow:2px 2px 0 #444">${MESSAGE}</h2></b>
</div>
			<div class="pic w3-animate-top">
				<br>
				<div class="w3-container w3-center">
					<img src = "pics/11.png" width="300" height="150" class="w3-padding">
				</div>
			</div>
<div  class="flex-container">	
	<div class="w3-col m6 l4 s12 w3-animate-left">
		<form action="Calculation7_12" method="GET" class="w3-container">
		
		  <h2 class="w3-text-white">Исходные данные</h2>
		  <input type="hidden" name="command" value="SCHEME11" />
		  <p>
		  <h4 class="w3-text-white">M, Н*м :</h4>
		  <input class="w3-input w3-border w3-round" name="moment" type="text" value="${MOMENT}"></p>
		  <p>
		  <h4 class="w3-text-white">l, мм :</h4>
		  <input class="w3-input w3-border w3-round" name="length" type="text" value="${LENGTH}"></p>
		  <p>
		  <h4 class="w3-text-white">h, мм :</h4>
		  <input class="w3-input w3-border w3-round" name="width" type="text" value="${WIDTH}"></p>
		  <p>
		  <h4 class="w3-text-white">k, мм :</h4>
		  <input class="w3-input w3-border w3-round" name="leg" type="text" value="${LEG}"></p>
		  <p>
		  <h4 class="w3-text-white">Материал сварного шва :</h4>
		  <select name="electrode" class="form-select" aria-label="Default select example">
					<option>OK Autrod 12.64</option>
					<option>OK Autrod 16.95</option>
		  </select>
		  <br><br>
		  <input type="submit" value="Рассчитать"/></p>
		  	<br>			
				<h4 class="w3-text-orange" style="text-shadow:2px 2px 0 #444">Расчетное напряжение, МПа : ${RESULT} </h4>
				<br>
				<h4 class="w3-text-orange" style="text-shadow:2px 2px 0 #444">Запас прочности : ${MARGIN}</h4>
				<br>
				<h4 class="w3-text-orange" style="text-shadow:2px 2px 0 #444">Используемый электрод : ${ELECTRODE} </h4>
				<br>
		</form>
	</div>
	<br><br><br><br>
	<div class="w3-container w3-center bottom w3-display-bottommiddle">
			<div class="bottom-text">
			  <h4><a href="index.html" class="w3-text-red">На главную</a></h4>
			</div>
	</div>	
	
</div>		
		
</body>

</html>