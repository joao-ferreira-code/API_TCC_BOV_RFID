package api.Bov_Corte._PageView_HTML;


public class ValidacaoCadastroUsuario {

    private String svgSucesso =
        "<svg xmlns='http://www.w3.org/2000/svg' width='60' height='60' fill='currentColor' class='bi bi-check-circle' viewBox='0 0 16 16'>\n" +
        "  <path d='M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z'/>\n" +
        "  <path d='M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z'/>\n" +
        "</svg>";

    private String elementoSucesso =
            "<div id='element'> \n\n" +
            "  <h2 class='cadastro'>Cadastro Realizado Com Sucesso!</h2>\n\n" +
            "  <h2 class='cadastro'>Seja Bem Vindo!</h2>\n\n" +
            "  <p>Usuário apto a utilizar os serviços fornecidos pela plataforma.</p>\n\n" +
            "</div>";

//----------------------------------------------------------------------------------------------------------------------//

    private String svgAlerta =
        "<svg xmlns='http://www.w3.org/2000/svg' width='60' height='60' fill='currentColor' class='bi bi-exclamation-circle' viewBox='0 0 16 16'>\n" +
        "  <path d='M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z'/>\n" +
        "  <path d='M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z'/>\n" +
        "</svg>";

    private String elementoAlerta = "<h2>Token Invalido ou </br>Não Reconhecido!</h2>";


//----------------------------------------------------------------------------------------------------------------------//

    private String svgError =
        "<svg xmlns='http://www.w3.org/2000/svg' width='60' height='60' fill='currentColor' class='bi bi-x-circle' viewBox='0 0 16 16'>\n" +
        "  <path d='M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z'/>\n" +
        "  <path d='M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z'/>\n" +
        "</svg>";

    private String elementoError =
            "<h2 class='cadastro'>Comportamento Insesperado!</h2>\n\n" +
            "<p>Tente novamente ou entre em contato com nosso time de suporte para solicitar ajuda.</p>";

//====================================================================================================================//

    public String gerarPaginaSucesso() {
        return gerarPagina(svgSucesso, "#00324D", elementoSucesso);
    }

//--------------------------------------------------------------------------------------------------------------------//

    public String gerarPaginaAlerta() {
        return gerarPagina(svgAlerta, "#d96936", elementoAlerta);
    }

//--------------------------------------------------------------------------------------------------------------------//

    public String gerarPaginaError() {
        return gerarPagina(svgError, "#db1d1d", elementoError);
    }

//--------------------------------------------------------------------------------------------------------------------//

    public String gerarPagiaSenhaGerada() {
        String elementoSenhaGerada =
                "<h2>Senha Alterada </br>Com Sucesso</h2>\n\n" +
                "<p>A nova senha foi enviada para o seu email.</p>";
        return gerarPagina(svgSucesso, "#00324D", elementoSenhaGerada);
    }

//====================================================================================================================//

    private String gerarPagina(String svg, String svgColor, String elemento) {

        String corpoResposta =
            "<!DOCTYPE html>" +
            "<html lang='pt-br'>\n" +
            "<head>\n" +
            "    <meta charset='UTF-8'>\n" +
            "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
            "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
            "    <title>Cadastro</title> \n\n" +

            "    <style>\n" +
            "        body{\n" +
            "            background-color: #b3d9ebbd;\n" +
            "        }\n" +
            "        svg{\n" +
            "            color: "+svgColor+";\n" +
            "        }\n" +
            "        .cadastro{\n" +
            "            font-size: 26pt;\n" +
            "            color: #00324D;\n" +
            "        }\n" +
            "        #corpo{\n" +
            "            width: 340px;\n" +
            "            height: 475px;\n" +
            "            border-radius: 20px;\n" +
            "            background-color: #568da9d7;\n" +
            "            text-align: center;\n" +
            "            position: absolute;\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            justify-content: center;\n" +
            "            align-items: center;\n" +
            "            top: 50%;\n" +
            "            left: 50%;\n" +
            "            transform: translate(-50%, -50%)\n" +
            "        }\n" +
            "        .botao{\n" +
            "            border: none;\n" +
            "            height: 35px;\n" +
            "            width: 180px;;\n" +
            "            border-radius: 35px;\n" +
            "            cursor: pointer;\n" +
            "            background-color:#00324D;\n" +
            "            font-size: 12pt;\n" +
            "            font-weight: bold;\n" +
            "            margin-top: 15px;\n" +
            "            color: white;\n" +
            "        }\n" +
            "        p{\n" +
            "            font-size: 14pt;\n" +
            "            padding: 5px;\n" +
            "            color: #023C5A;\n" +
            "        }\n" +
            "        #x{\n" +
            "            height: 70px;\n" +
            "        }\n" +
            "    </style> \n\n" +
            "</head> \n\n" +

            "<body> \n\n" +

            "    <div id='corpo'> \n" +

            "        " + svg + "\n\n" +

            "        " + elemento + " \n\n" +

            "        <button class='botao' onclick='window.close()'> Fechar </button> \n\n" +

            "    </div>\n\n" +

            "</body>\n" +
            "</html>";

        return corpoResposta;
    }

//====================================================================================================================//

}

