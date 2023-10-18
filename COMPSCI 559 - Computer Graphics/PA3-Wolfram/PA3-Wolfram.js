function setup() {
  var canvas = document.getElementById("asdf");
  var ctx = canvas.getContext("2d");

  const { mat3, vec2} = glMatrix;

  var stack = [ mat3.create() ];
  function createStack() {stack = [ mat3.create() ];}

  //                        Mercury,  Venus,      Earth,  Mars,       Jupiter,    Saturn,     Uranus,     Neptune,        Pluto,      Earth's Moon
  const orbSpdCnst     =   [0.016,    0.0048,     0.003,  0.0015,     0.001307,   0.0009609,  0.000681,   0.000543,       0.000474,   0.025];
  const dist_from_sun  =   [60,       90,         125,    170,        240,        310,        360,        400,            420,        15];
  const planetSizes    =   [5,        8,          10,     7,          30,         25,         14,         15,             2,          2];
  const planetColor    =   ['gray',   '#a57c1b',  'blue', '#c1440e',  '#e3dccb',  '#d1a12e',  '#184996',  'lightblue',    'tan',      'gray'];
  const orbital_speed  =   [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

  function updateOrbitSpeeds()
  {
      for (var i = 0; i < 10; i++) 
      {
          orbital_speed[i] += orbSpdCnst[i];
          if (orbital_speed[i] > 360) { orbital_speed[i] = orbSpdCnst[i]; }
      }
  }

  function drawOrbitRings()
  {
      ctx.strokeStyle = 'white';
      ctx.lineWidth = 0.5;

      for (var i = 0; i < 9; i++)
      {
          ctx.beginPath();
          ctx.arc(450, 435.5, dist_from_sun[i], 0, 2 * Math.PI);
          ctx.stroke();
      }
  }

  function orbitX(r, t)
  { return (Math.floor(r * (Math.cos(t)))); }

  function orbitY(r, t)
  { return (Math.floor(r * (Math.sin(t)))); }

  function moveToTx(x,y)  
  { var res=vec2.create(); vec2.transformMat3(res,[x,y],stack[0]); ctx.moveTo(res[0],res[1]); }

  function lineToTx(x,y)
  { var res=vec2.create(); vec2.transformMat3(res,[x,y],stack[0]); ctx.lineTo(res[0],res[1]); }

  function drawPlanet(width, color, Tx)
  {
      ctx.beginPath();
      ctx.fillStyle = color;
      moveToTx(0,-width,Tx);
      lineToTx(width,0,Tx);
      lineToTx(0,width,Tx);
      lineToTx(-width,0,Tx);
      ctx.closePath();
      ctx.fill();
  }

  function drawPlanetTx(dist_from_sun_i, orbital_speed_i, planetSizes_i, planetColor_i)
  {
      stack.unshift(mat3.clone(stack[0]));
      var Tx = mat3.create();
      mat3.fromTranslation(Tx, [
          orbitX(dist_from_sun[dist_from_sun_i], orbital_speed[orbital_speed_i]), 
          orbitY(dist_from_sun[dist_from_sun_i], orbital_speed[orbital_speed_i])
      ]);
      mat3.multiply(stack[0],stack[0],Tx);
      drawPlanet(planetSizes[planetSizes_i],planetColor[planetColor_i],Tx);
  }


  function drawAllPlanets()
  {
      for (var i = 0; i < 9; i++)
      {
          if (i == 2)
          {
              continue;
          }
          drawPlanetTx(i, i, i, i);
          stack.shift();
      }

  }

  function drawEarthAndMoon()
  {
      drawPlanetTx(2, 2, 2, 2);

      stack.unshift(mat3.clone(stack[0]));
      var Tmoon_to_earth = mat3.create();
      mat3.fromTranslation(Tmoon_to_earth, [0,0]);
      mat3.multiply(stack[0],stack[0],Tmoon_to_earth);
      
      stack.unshift(mat3.clone(stack[0]));
      var Tmoon_orbit = mat3.create();
      mat3.fromTranslation(Tmoon_orbit, 
          orbitX(dist_from_sun[9], orbital_speed[9]), 
          orbitY(dist_from_sun[9], orbital_speed[9])
      );
      mat3.multiply(stack[0],stack[0],Tmoon_to_earth);
      drawPlanetTx(9, 9, 9, 9);
  }

  function draw()
  {
      canvas.width = canvas.width;
      
      createStack();

      //Translates to center of canvas
      var T1 = mat3.create();
      mat3.fromTranslation(T1, [450,435.5]);
      mat3.multiply(stack[0],stack[0],T1);
      drawPlanet(30, 'yellow', T1);
      drawOrbitRings();

      drawAllPlanets();

      drawEarthAndMoon();

      window.requestAnimationFrame(draw);

      updateOrbitSpeeds();
  }
  draw();
}
window.onload = setup;