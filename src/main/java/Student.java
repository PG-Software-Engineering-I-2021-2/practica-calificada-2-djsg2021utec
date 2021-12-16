class Student {
    private String _Nombre;
    private int _Tipo;
    private int _notaBase =11;
    static final int Pregado = 0;
    static final int Maestria = 1;
    static final int Doctorado = 2;

   Student(int type, String nombre) {
        _Tipo = type;
        _Nombre = nombre;
    }


    int Grado() {
        switch (_Tipo) {
            case Pregado:
                return _notaBase;
            case Maestria:
                return _notaBase + 1;
            case Doctorado:
                return _notaBase + 2;
            default:
                throw new RuntimeException("Empleado incorrecto");
        }
    }

}



/*

    public Student(int type, String nombre, int _notaBase){
        this._Tipo = type;
        this._Nombre = nombre;
        this._notaBase = _notaBase;
    }

    abstract int Grado();
 */
/*
class Pregrado extends Student {
    public Pregrado(int type, String nombre,int _notaBase) {
        super(type, nombre,_notaBase);
    }


    int Grado(){
        return _notaBase;
    }
}

class Maestria extends Student {
    public Maestria(int type, String nombre, int _notaBase) {
        super(type, nombre, _notaBase);
    }
    int Grado(){
        return _notaBase + 1;
    }
}

class Doctorado extends Student {
    public Doctorado(int type, String nombre, int _notaBase) {
        super(type, nombre, _notaBase);
    }
    int Grado(){
        return _notaBase + 2;
    }
}
*/
/*
    private String _Nombre;
    private int _Tipo;
    private int _notaBase =11;


     abstract int Grado();
 class Pregrado extends Student {
     int Grado(){
         return _notaBase;
     }
 }
 */

