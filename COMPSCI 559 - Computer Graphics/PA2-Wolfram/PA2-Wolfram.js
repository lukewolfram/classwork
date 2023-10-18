function setup() {
  var canvas = document.getElementById("myCanvas");
  var ctx = canvas.getContext("2d");
  var w = canvas.width; var centerX = w / 2;
  var h = canvas.height; var centerY = h / 2;
  var slider1 = document.getElementById('slider1'); slider1.value = 0;

  var mercurySpeed = 0; var venusSpeed = 0; var earthSpeed = 0;
  var marsSpeed = 0; var jupiterSpeed = 0; var saturnSpeed = 0;
  var neptuneSpeed = 0; var uranusSpeed = 0; var moonSpeed = 0;
  var plutoSpeed = 0;
  
  function drawSun() {
      ctx.beginPath();
      ctx.arc(centerX, centerY, 50, 0, Math.PI * 2);
      ctx.fillStyle = 'yellow';
      ctx.fill();
  }
  
  function drawEarth() {
      ctx.beginPath();
      ctx.arc(125, 0, 10, 0, Math.PI * 2);
      ctx.fillStyle = '#4f4cb0';
      ctx.fill();
      ctx.beginPath();
      ctx.fillStyle = '#9fc164';
      ctx.rect(116, -4, 7, 5); ctx.rect(118, -1, 5, 6);
      ctx.rect(126, -5, 5, 5); ctx.rect(126, 0, 7, 5);
      ctx.fill();
    
      ctx.beginPath();
      ctx.fillStyle = '#e9eff9';
      ctx.rect(121, 8, 8, 3); ctx.rect(124, -10, 2, 2);
      ctx.fill();
    
      ctx.beginPath();
      ctx.strokeStyle = 'black'; ctx.lineWidth = 1;
      ctx.arc(125, 0, 11, 0, Math.PI * 2);
      ctx.stroke();

      if (slider1.value >= 90) {
        drawEarthExplosion();
        }
  }
  
  function drawJupiter() {
      ctx.beginPath();
      ctx.arc(240, 0, 30, 0, Math.PI * 2);
      ctx.fillStyle = '#e3dccb';
      ctx.fill();
      
      ctx.beginPath();
      ctx.strokeStyle = '#d8ca9d'; ctx.lineWidth = 10;
      ctx.moveTo(210, -15); ctx.lineTo(270,-15);
      ctx.moveTo(210, 9); ctx.lineTo(270, 9);
      ctx.stroke();
    
      ctx.beginPath();
      ctx.strokeStyle = '#ebf3f6'; ctx.lineWidth = 4;
      ctx.moveTo(210, -8); ctx.lineTo(270, -8);
      ctx.moveTo(210, 4); ctx.lineTo(270, 4);
      ctx.moveTo(210, 16); ctx.lineTo(270, 16);
      ctx.stroke();
      
      ctx.beginPath();
      ctx.strokeStyle = '#c99039'; ctx.lineWidth = 6;
      ctx.moveTo(210, -2); ctx.lineTo(270, -2);
      ctx.moveTo(215, 20); ctx.lineTo(265, 20);
      ctx.stroke();
    
      ctx.beginPath();
      ctx.fillStyle = '#c99039';
      ctx.ellipse(227, 9, 6, 5, Math.PI / 1.25, 0, 2 * Math.PI);
      ctx.fill();
    
      ctx.beginPath();
      ctx.strokeStyle = 'black'; ctx.lineWidth = 6;
      ctx.arc(240, 0, 33, 0, Math.PI * 2);
      ctx.stroke();
      ctx.closePath();
  }

  function drawSaturn() {
      ctx.beginPath();
      ctx.arc(310, 0, 25, 0, Math.PI * 2);
      ctx.fillStyle = '#d1a12e'; ctx.strokeStyle = '#614910';
      ctx.fill();
      
      ctx.beginPath();
      ctx.lineWidth = 4;
      ctx.ellipse(310, 0, 15, 35, 4, 1, 5.3);
      ctx.stroke();
  }

  function drawPlanet(distFromSun, radius, color) {
    ctx.beginPath();
    ctx.arc(distFromSun, 0, radius, 0, Math.PI * 2);
    ctx.fillStyle = color;
    ctx.fill();
  }

  function updateSpeeds() {
    mercurySpeed += 0.4787;
    venusSpeed += 0.3502;
    earthSpeed += 0.002978;
    moonSpeed += .04;
    marsSpeed += 0.12;
    jupiterSpeed += 0.001307;
    saturnSpeed += 0.0009609;
    uranusSpeed += 0.0681;
    neptuneSpeed += 0.0543;
    plutoSpeed += 0.0474;
  }

  function drawMeteor() {
      ctx.beginPath();
      ctx.fillStyle = 'gray';
      ctx.arc(-.25, -.25, 0.15, 0, Math.PI * 2);
      ctx.fill();
  }

  function drawEarthExplosion() {
    ctx.beginPath();
    ctx.fillStyle = 'red';

    ctx.moveTo(110, 10); ctx.lineTo(122, -15); ctx.lineTo(138, 9);
    ctx.moveTo(139, -8); ctx.lineTo(125, 15); ctx.lineTo(108, -10);
    ctx.fill();
  
    ctx.beginPath();
    ctx.fillStyle = 'orange';
    ctx.moveTo(114, 8); ctx.lineTo(122, -11); ctx.lineTo(134, 7);
    ctx.moveTo(135, -6); ctx.lineTo(125, 12); ctx.lineTo(112, -8);
    ctx.fill();
  }

  function drawOrbitRing(radius) {
    ctx.beginPath();
    ctx.arc(0, 0, radius, 0, 2 * Math.PI);
    ctx.stroke();
  }

  const planetDists = [60, 90, 125, 170, 240, 310, 360, 400, 430];
  //Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto

  function drawOrbitRings() {
    ctx.strokeStyle = 'white'; ctx.lineWidth = 0.5;

    for (var i = 0; i < 9; i++) {
      drawOrbitRing(planetDists[i]);
    }

    ctx.beginPath();
    ctx.save();
    ctx.translate(125 * Math.cos(earthSpeed), 125 * Math.sin(earthSpeed));
    ctx.arc(0, 0, 20, 0, 2 * Math.PI);
    ctx.restore();
    ctx.stroke();
  }

  
function draw() {
  ctx.save();
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  //Orbit Rings
  ctx.save();
  ctx.translate(centerX, centerY);
  drawOrbitRings();
  ctx.restore();
  
  //Mercury
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.rotate(135);
  ctx.rotate((mercurySpeed * Math.PI) / 180);
  drawPlanet(60, 3.5, 'gray');
  ctx.restore();
  
  //Venus
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.rotate(62);
  ctx.rotate((venusSpeed * Math.PI) / 180);
  drawPlanet(90, 8, '#a57c1b');
  ctx.restore();
  
  //Earth
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.translate(125 * Math.cos(earthSpeed) - 125, 125 * Math.sin(earthSpeed));
  drawEarth();
  ctx.restore();
  
  //Meteor
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.translate(125 * Math.cos(earthSpeed) - 90, 125 * Math.sin(earthSpeed) + 25);
  ctx.translate(slider1.value, 0);
  ctx.scale(slider1.value, slider1.value);
  drawMeteor();
  ctx.restore();

  //Earth's moon
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.translate(125 * Math.cos(earthSpeed) - 125, 125 * Math.sin(earthSpeed));
  ctx.translate(20 * Math.cos(moonSpeed) - 5, 20 * Math.sin(moonSpeed) - 7);
  ctx.rotate((3 * Math.PI) / 180);
  drawPlanet(130, 2, '#c9c9c9');
  ctx.restore();
  
  //Mars
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.rotate(45);
  ctx.rotate((marsSpeed * Math.PI) / 180);
  drawPlanet(170, 7, '#c1440e');
  ctx.restore();
  
  //Jupiter
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.translate(240*Math.cos(jupiterSpeed) - 240, 240*Math.sin(jupiterSpeed));
  drawJupiter();
  ctx.restore();
  
  //Saturn
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.translate(310*Math.cos(saturnSpeed) - 310, 310*Math.sin(saturnSpeed));
  drawSaturn();
  ctx.restore();
  
  //Uranus
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.rotate(180);
  ctx.rotate((uranusSpeed * Math.PI) / 180);
  drawPlanet(360, 14, '#184996');
  ctx.restore();
  
  //Neptune
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.rotate(210);
  ctx.rotate((neptuneSpeed * Math.PI) / 180);
  drawPlanet(400, 15, 'lightblue');
  ctx.restore();
  
  //Pluto
  ctx.save();
  ctx.translate(centerX, centerY);
  ctx.rotate(135);
  ctx.rotate((plutoSpeed * Math.PI) / 180);
  drawPlanet(430, 3, 'tan');
  ctx.restore();
  
  drawSun();
  window.requestAnimationFrame(draw);
  updateSpeeds();
  }
draw();
}
window.onload = setup;