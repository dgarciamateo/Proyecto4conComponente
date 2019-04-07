
import SQL.ConectorSQLBean;
import SQL.GuardarRegistros;

public class Principal {

	static GuardarRegistros guRegis = new GuardarRegistros();
	static ConectorSQLBean c;
	public static void main(String[] args) {

		/*
		 * ENTRAMOS CON EL PRIMER USUARIO: cleanGuy
		 * CON LA CONTRASENYA: P@ssw0rd
		 * EN LA BASE DE DATOS: prueba
		 */
		
		String usuario = "cleanGuy";
		String bbdd = "prueba";
		String password = "P@ssw0rd";
		

		c = new ConectorSQLBean("localhost", "3306", bbdd, usuario, password);
		c.conectarBBDD();

		guRegis.sentencia(c, "DELETE FROM empresa WHERE nombre = 'Mi casa'", usuario, bbdd);
		guRegis.sentencia(c, "DELETE FROM empleado WHERE nombre = 'Sergi'", usuario, bbdd);
		guRegis.sentencia(c, "DELETE FROM empresa WHERE nombre = 'Esteve Terrades'", usuario, bbdd);

		
		c.desconectarBBDD();

		
		/*
		 * ENTRAMOS CON EL SEGUNDO USUARIO: root
		 * CON LA CONTRASENYA VACIA
		 * EN LA MISMA BASE DE DATOS: prueba
		 * CREAMOS CONEXION, HACEMOS CONSULTAS Y CERRAMOS CONEXION
		 */
		
		
		usuario = "root";
		password = "";
		c = new ConectorSQLBean("localhost", "3306", bbdd, usuario, password);
		c.conectarBBDD();

		guRegis.sentencia(c, "CALL verEmpleadosNombre()", usuario, bbdd);
		guRegis.sentencia(c, "SELECT * FROM empleado WHERE nombre = 'David'", usuario, bbdd);
		guRegis.sentencia(c, "UPDATE empleado SET id_empresa = 2 WHERE id_empresa = 4", usuario, bbdd);
		guRegis.sentencia(c, "INSERT INTO empresa(nombre, direccion) VALUES('Mi casa', 'Calle Dr.vila')",usuario, bbdd);
		guRegis.sentencia(c, "INSERT INTO empleado(nombre, apellidos, telefono, id_empresa) VALUES('Sergi', 'Vaghi Garcia', 6785934, 8)",usuario, bbdd);
		
		c.desconectarBBDD();
		
		
		/*
		 * ENTRAMOS CON EL TERCER USUARIO: guts
		 * CON LA CONTRASENYA VACIA
		 * EN LA MISMA BASE DE DATOS: prueba
		 * CREAMOS CONEXION, HACEMOS CONSULTAS, FALLAMOS CON ALGUNAS PARA COMPROBAR QUE LOS ERRORES ESTAN CONTEMPLADOS Y CERRAMOS CONEXION
		 */

		usuario = "guts";
		password = "";
		c = new ConectorSQLBean("localhost", "3306", bbdd, usuario, password);
		c.conectarBBDD();

		guRegis.sentencia(c, "SELECT * FROM oficina WHERE id_empresa = 2", usuario, bbdd);
		guRegis.sentencia(c, "SELECT * FROM empleado WHERE id_empresa = 2", usuario, bbdd);
		guRegis.sentencia(c, "INSERT INTO empresa(nombre, direccion_empresarial) VALUES('Esteve Terrades', 'Calle de la sabiduria')",usuario, bbdd);
		guRegis.sentencia(c, "INSERT INTO empresa(nombre, direccion) VALUES('Esteve Terrades', 'Calle de la sabiduria')",usuario, bbdd);
		
		c.desconectarBBDD();
		
		
		
		/*
		 * ENTRAMOS CON EL MISMO USUARIO: guts
		 * CON LA CONTRASENYA VACIA
		 * CAMBIAMOS LA BASE DE DATOS A: cartas
		 * CREAMOS CONEXION, HACEMOS CONSULTAS Y CERRAMOS CONEXION
		 */

		bbdd = "cartas";
		c = new ConectorSQLBean("localhost", "3306", bbdd, usuario, password);
		c.conectarBBDD();

		guRegis.sentencia(c, "INSERT INTO carta(nombre, valor, ataque, defensa) VALUES('Exodia', 5, 100, 50)", usuario,bbdd);
		guRegis.sentencia(c, "SELECT * FROM carta", usuario, bbdd);
		guRegis.sentencia(c, "DELETE FROM carta WHERE nombre = 'Exodia'", usuario, bbdd);


		c.desconectarBBDD();


		/*
		 * UNA VEZ HECHAS TODAS LAS PRUEBAS, COMPROBAREMOS EL SISTEMA DE PRINTADO DE REGISTROS MEDIANTE FILTROS
		 * PARA EMPEZAR FILTRAREMOS POR BASE DE DATOS Y USUARIO
		 * SEGUIDAMENTE FILTRAREMOS POR BASE DE DATOS Y TIPO DE CONSULTA
		 * Y PARA FINALIZAR FILTRAREMOS POR LOS TRES CAMPOS POSIBLES, BASE DE DATOS USUARIO Y TIPO DE CONSULTA
		 */
		
		
		
		System.out.println("Busqueda de consultas realizadas en prueba por el usuario: " + "root");
		guRegis.printRegis("prueba", "root", "");

		System.out.println("Busqueda de consultas de tipo INSERT realizadas en prueba");
		guRegis.printRegis("prueba", "", "INSERT");

		System.out.println("Busqueda de consultas de tipo SELECT realizadas en " + bbdd + " por el usuario: " + "guts");
		guRegis.printRegis("cartas", "guts", "SELECT");

		
		

		//EL COMPONENTE TIENE UN METODO QUE DEVUELVE POR PANTALLA LA LISTA ENTERA DE REGISTROS DESDE QUE ARRANCA LA APLICACION
	
//		System.out.println("Lista entera de los registros");
//		guRegis.printAllRegis();

	}
}
