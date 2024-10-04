method Main (){
var resultadoFinal := sumaSecuencia([1,-42,3,4,5]);
print resultadoFinal ;
}

method Triple(x :int) returns (r :int)
ensures r >= 3*x
{
    if 0 <= x {
        var y := Doble(x);
        r := x + y;
    } else {
        var y := Doble(-x);
        r := x + y;
    }
}

method Doble(x :int) returns (r :int)
requires 0 <= x
ensures r >= 2*x
{
    r := x + x;
}

method sumMax(x :int, y :int) returns (s :int, m :int)
ensures s == x + y
ensures x <= m && y <= m
ensures m == x || m == y
{
    s := x + y;
    if x < y {
        m := y;
    } else {
        m := x;
    }
}
/*
method esNatural(numero :real) returns (esNatural :bool)
ensures esNatural == ((numero >= 0.0) && ((numero.Floor as real) == numero))
{  
    var num := numero;
    if (num > 0.0){    
        while num > 0.0 {
            num := num - 1.0;
        }
        if(num == 0.0){ //El numero no tiene decimales
            esNatural := true;
        } else {
            esNatural := false;
        }
    } else { //El numero no es positivo
        esNatural := false;
    }
}

method sumaSecuencia(secuencia :seq<nat>) returns (suma :nat)
requires |secuencia| > 0
requires secuencia[0] == 1
ensures suma >= 1
{
    suma := 1;
    for i :nat := 1 to |secuencia| {
        suma := suma + secuencia[i];
    }
}
*/
method sumaSecuencia(secuencia :seq<nat>) returns (suma :nat)
requires |secuencia| > 0
requires secuencia[0] == 1
ensures suma >= 1
{
    suma := sumar(secuencia);
}

function sumar(sec :seq<nat>) :nat {
    if |sec| == 0 then
        0
    else
        sec[0] + sumar(sec[1..])
}

method EsCapicua(arr :array<int>) returns (capicua :bool)
{
    var cont := 0;
    var longi := arr.Length;
    capicua := true;

    while cont < longi / 2 && capicua{
        capicua := arr[cont] == arr[longi - 1 - cont];
        cont := cont + 1;
    }
}
