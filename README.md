TestMu PoC Practice
Objetivo
Prueba de concepto utilizando Selenium WebDriver, Maven y JUnit para automatizar escenarios funcionales en SauceDemo.

Arquitectura
El proyecto sigue el patrón Page Object Model (POM).

Estructura:

src/test/java

driver/ pages/ tests/ utils/

driver
Contiene DriverFactory.

Permite ejecutar pruebas:

Local (ChromeDriver)
TestMu (RemoteWebDriver)
pages
Contiene objetos de página.

Ejemplo:

LoginPage
tests
Contiene los casos de prueba.

utils
Contiene utilitarios.

Ejemplo:

EvidenceManager
Configuración
Requisitos:

Java 21
Maven 3.9+
Eclipse IDE
Chrome
Verificar:

mvn -version

Casos implementados
POC-W001 Login válido
Valida:

Usuario correcto
Password correcto
Acceso a Products
Resultado:

PASS

POC-W002 Login inválido
Valida:

Usuario incorrecto
Password incorrecto
Resultado esperado:

Epic sadface

POC-W003 Ver inventario
Valida:

Visualización del catálogo
Resultado:

Productos visibles

POC-W004 Logout
Valida:

Cierre de sesión
Resultado:

Regreso a Login

POC-W005 Agregar producto
Valida:

Agregar producto al carrito
Resultado:

Badge = 1

POC-W006 Quitar producto
Valida:

Eliminación del producto
Resultado:

Carrito vacío

Evidencias
Carpeta:

artifacts/

Genera:

session.txt
POC-W001.txt
POC-W002.txt
POC-W003.txt
POC-W004.txt
POC-W005.txt
POC-W006.txt
screenshot.png (cuando ocurre un error)
Ejecución
Ejecutar:

mvn test

Resultado esperado:

BUILD SUCCESS
