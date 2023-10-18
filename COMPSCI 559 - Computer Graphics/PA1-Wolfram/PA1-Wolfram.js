 function setup() {
  var canvas = document.getElementById('myCanvas');

  var slider1 = document.getElementById('slider1'); slider1.value = 0;
  var slider2 = document.getElementById('slider2'); slider2.value = 0;

  function draw() {
    var context = canvas.getContext('2d');
    var dx = slider1.value;
    var dyLightning = slider2.value;
    
    //grass
    context.lineWidth = 150;
    context.strokeStyle = "green";
    context.beginPath();
    context.moveTo(0,425);
    context.lineTo(1250,425);
    context.stroke();
    
    //sky
    context.lineWidth = 350;
    context.strokeStyle = "blue";
    context.beginPath();
    context.moveTo(0,175); context.lineTo(1250,175);
    context.stroke();
    
    //sun
    context.fillStyle = "yellow";
    context.beginPath();
    context.moveTo(0,0);
    context.lineTo(0,100); context.lineTo(37, 95); context.lineTo(75,75);
    context.lineTo(95,37); context.lineTo(100,0);
    context.fill();

    function drawLightning() {
      context.strokeStyle = "yellow";
      context.lineWidth = 12;
      context.beginPath();
      context.moveTo(125, 65);
      context.lineTo(155, 110); context.lineTo(140, 150); context.lineTo(150, 199);
      context.moveTo(225, 55);
      context.lineTo(200, 125); context.lineTo(237, 175);
      context.moveTo(275, 60);
      context.lineTo(290, 160); context.lineTo(260, 190);
      context.stroke();

      drawRaindrop(100, 120); drawRaindrop(175, 80); drawRaindrop(200, 160);
      drawRaindrop(250, 110); drawRaindrop(325, 90); drawRaindrop(125, 175);
    }

    function drawRaindrop(x, y) {
      context.strokeStyle = "black";
      context.fillStyle = "lightblue";
      context.lineWidth = .5;

      context.beginPath();
      context.moveTo(x, y);
      context.lineTo(x - 4, y + 8); context.lineTo(x, y + 12); context.lineTo(x + 4, y + 8);
      context.closePath();
      context.fill();
      context.stroke();
    }

    context.save();
    context.translate(dx, dyLightning);
    drawLightning();
    context.restore();

    function drawCloud() {
      context.fillStyle = "lightgray";
      context.strokeStyle = "lightgray";
      context.lineWidth = 100;  
      context.beginPath();

      //draw rectangle base  
      context.moveTo(100,150);
      context.lineTo(300,150);
      context.stroke();  
      
      //draw lumpy bits
      context.moveTo(100,150);  
      context.arc(100, 150, 50, 0, 2 * Math.PI);
      context.moveTo(300,125);
      context.arc(300, 125, 75, 0, 2 * Math.PI);
      context.moveTo(182,118);
      context.arc(182, 118, 82, 0, 2 * Math.PI);
              
      context.fill();
    }

    context.save();
    context.translate(dx, 0);
    drawCloud();
    context.restore();

    //house
    context.lineWidth = 250;
    context.strokeStyle = "tan";
    context.beginPath();
    context.moveTo(350,275); context.lineTo(900,275);
    context.stroke();
    
    //roof
    context.fillStyle = "gray";
    context.beginPath();
    context.moveTo(275,150); context.lineTo(975,150); context.lineTo(625,50);
    context.fill();
    
    //door
    context.lineWidth = 100;
    context.strokeStyle = "brown";
    context.beginPath();
    context.moveTo(625,400); context.lineTo(625,250);
    context.stroke();
    
    //doorknob
    context.lineWidth = 10;
    context.strokeStyle = "black";
    context.beginPath();
    context.moveTo(660,350); context.lineTo(660,340);
    context.stroke();
    
    //left window
    context.lineWidth = 100;
    context.strokeStyle = "lightblue";
    context.beginPath();
    context.moveTo(400,250); context.lineTo(525,250);
    context.stroke();
    
    //right window
    context.beginPath();
    context.moveTo(725,250); context.lineTo(850,250);
    context.stroke();
    
    //left window pane
    context.lineWidth = "3";
    context.strokeStyle = "black";
    context.beginPath();
    context.moveTo(462,300); context.lineTo(462,200);
    context.moveTo(400,250); context.lineTo(525,250);
    context.stroke();
    
    //right window pane
    context.beginPath();
    context.moveTo(787,300); context.lineTo(787,200);
    context.moveTo(725,250); context.lineTo(850,250);
    context.stroke();
   }

  slider1.addEventListener("input",draw);
  slider2.addEventListener("input",draw);
  draw();
}

window.onload = setup;