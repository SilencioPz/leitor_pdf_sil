📓 Leitor de PDF (Java Swing)
<p align="center"> <img src="https://img.icons8.com/fluency/96/000000/document.png" width="100"> <br> <em>Leitor de PDF utilizando Apache PDFBox</em> </p>
----------------------------------------------------------------------------------------------------------------------------------------------------------

✨ Sobre o Projeto

Aplicativo desktop desenvolvido em Java Swing que permite:

    ✅ Ler arquivos PDF de forma rápida e silenciosa (sem bloatware).

    🎨 Interface minimalista, mas nos moldes dark.

    🚫 Formatos não suportados: .txt, .docx, .xlsx (LibreOffice/Word/Excel).
----------------------------------------------------------------------------------------------------------------------------------------------------------
  🚀 Roadmap
----------------------------------------------------------------
Versão	       |   Status  |	        Observação               |
----------------------------------------------------------------
Java Swing	   |✅ Completo|	Versão estável (IntelliJ + Maven)|
----------------------------------------------------------------
Multiplataforma|🔄 Em breve|	Suporte para Linux/Mac/Windows   |
----------------------------------------------------------------------------------------------------------------------------------------------------------
🛠️ Tecnologias & Ferramentas
----------------------------------------------------------------------------------------------------------------------------------------------------------
Componente	  Detalhes
----------------------------------------------------------------------------------------------------------------------------------------------------------
Linguagem	    Java 17 (OpenJDK)
----------------------------------------------------------------------------------------------------------------------------------------------------------
IDE	          IntelliJ IDEA
----------------------------------------------------------------------------------------------------------------------------------------------------------
Biblioteca	  Apache PDFBox 2.0.29
----------------------------------------------------------------------------------------------------------------------------------------------------------
Build Tool	  Maven
----------------------------------------------------------------------------------------------------------------------------------------------------------
📂 Estrutura do Projeto
----------------------------------------------------------------------------------------------------------------------------------------------------------
LeitorPDFSilencioso/
├── src/
│   ├── main/java/org/example/
│   │   ├── Main             # Arquivo Principal
│   │   ├── MainFrame/       # Interface Swing    
│   │   └── PDFViewer/       # Classes de dados     
│   └── test/                # Testes unitários
├── target/                  # Builds (ignorado pelo Git)
└── LeitorPDFSilencioso-1.0-SNAPSHOT.jar    # Executável final
----------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Como Executar
Pré-requisitos

    Java 17+ instalado (java -version).

    Arquivos PDF para teste (ex: /home/usuario/Downloads/doc.pdf).
----------------------------------------------------------------------------------------------------------------------------------------------------------
Métodos
1. Via JAR:
   java -jar LeitorPDFSilencioso-1.0-SNAPSHOT.jar
   
3. No IntelliJ:

    Importe como projeto Maven.

    Execute Main.java (classe principal).

----------------------------------------------------------------------------------------------------------------------------------------------------------
   🔒 Boas Práticas

✔️ .gitignore otimizado para Java/Maven.
✔️ Arquitetura MVC (Model-View-Controller).
✔️ Tratamento de exceções para arquivos inválidos.
✔️ Documentação no código (JavaDoc).
----------------------------------------------------------------------------------------------------------------------------------------------------------
🌟 Próximos Passos

    🔗 Suporte a arrastar-e-soltar (drag and drop).

    🖨️ Exportar trechos do PDF como texto.

    🐧 Build automático para Linux (.deb/.rpm).
----------------------------------------------------------------------------------------------------------------------------------------------------------
<p align="center"> 👨‍💻 Desenvolvido com café e música! <br> <img src="https://img.icons8.com/color/48/000000/brazil.png" width="20"> <em>Feito no Brasil com muita zuera!!!</em> 😄 </p> ```
