

/*===================================== ACOES SISTEMA ======================================*/


    CREATE TABLE log4j (
        log_nr_id 	BIGINT NOT NULL AUTO_INCREMENT,
        log_tx_sistema 		varchar(200) NOT NULL,
        log_tx_classe 		varchar(200) NOT NULL,
        log_tx_metodo 		varchar(100) NOT NULL,
        log_tx_usuario 		varchar(200) NOT NULL,
        log_dt_datahora 	timestamp NOT NULL DEFAULT now(),
        log_tx_status 		tinyint(1) NOT NULL DEFAULT '1',
        log_tx_ip 			varchar(200) NOT NULL DEFAULT '127.0.0.1',
        log_tx_parametros 	varchar(5000) NULL DEFAULT ' ',
        PRIMARY KEY (log_nr_id)
    ); /* >> Auditoria */


	CREATE TABLE estado (
	  	pk_estado 			int NOT NULL AUTO_INCREMENT,
	  	tx_nome 			varchar(50) NOT NULL,
	  	tx_Sigla 			varchar(2) NOT NULL,
	  	dt_cadastro 		date NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_estado)
	) 

	
	CREATE TABLE cidade (
	  	pk_cidade 			int NOT NULL AUTO_INCREMENT,
	  	fk_estado 			int NOT NULL,
	  	tx_nome 			varchar(75) NOT NULL,
	  	dt_cadastro 		date NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_cidade)
	) 
	
	
	CREATE TABLE raca_bolvino (
	  	pk_raca 			int NOT NULL AUTO_INCREMENT,
	  	tx_nome 			varchar(75) NOT NULL,
	  	tx_descricao 		varchar(250) NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		date NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_raca)
	) 
	
	
	CREATE TABLE nivel_acesso (
	  	pk_nivel_aceso_fazenda 			int NOT NULL AUTO_INCREMENT,
	  	tx_nome 						varchar(75) NOT NULL,
	  	tx_descricao_nivel_acesso 		varchar(250) NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		date NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_nivel_aceso_fazenda)
	) 


/*========================================= PORTAL =========================================*/

	CREATE TABLE usuario (
	  	pk_usuario 			int NOT NULL AUTO_INCREMENT,
	  	fk_cidade 			int NOT NULL,
	  	tx_nome 			varchar(150) NOT NULL,
	  	dt_nascimento 		date NOT NULL,
	  	tx_telefone 		varchar(20) NOT NULL,
	  	tx_login 			varchar(150) NOT NULL UNIQUE,
	  	tx_senha 			varchar(150) NOT NULL,
	  	tx_token 			varchar(250) DEFAULT NULL,
	  	is_autenticado 		tinyint(1) NOT NULL DEFAULT '0',
	  	is_verficado 		tinyint(1) NOT NULL DEFAULT '0',
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '0',
	  	dt_cadastro 		datetime NOT NULL,
	  	PRIMARY KEY (pk_usuario)
	) 
	
	CREATE TABLE foto_usuario (
	  	pk_foto_usuario 	int NOT NULL AUTO_INCREMENT,
	  	fk_usuario 			int NOT NULL,
	  	bt_foto_usuario 	LONGBLOB NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		date NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_foto_usuario)
	) 
	
	
	CREATE TABLE recuperar_senha (
	  	pk_recuperacao 			int NOT NULL AUTO_INCREMENT,
	  	fk_usuario 			int NOT NULL,
	  	tx_token 			varchar(250) DEFAULT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		datetime NOT NULL,
	  	PRIMARY KEY (pk_recuperacao)
	) 
	
	
/*===================================== FAZENDA =====================================*/
	
	
	
	CREATE TABLE fazenda (
	  	pk_fazenda 	int NOT NULL AUTO_INCREMENT,
	  	fk_usuario_cadastrou int NOT NULL,
	  	fk_cidade 			int NOT NULL,
	  	tx_nome 			varchar(150) NOT NULL,
	  	nr_total_hectares 	double NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		datetime NOT NULL default CURDATE(),
	  	dt_remocao 			datetime,
	  	tx_codigo_publico 		varchar(100) NOT NULL,
	  	tx_telefone 		    varchar(20),
	  	PRIMARY KEY (pk_fazenda)
	) 
	
	
	CREATE TABLE foto_fazenda (
	  	pk_foto_fazenda 	int NOT NULL AUTO_INCREMENT,
	  	fk_fazenda 			int NOT NULL,
	  	fk_usuario_cadastrou 	int NOT NULL,
	  	bt_foto_fazenda 	LONGBLOB NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		date NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_foto_fazenda)
	) 
	
	
	CREATE TABLE colaborador_fazenda (
	  	pk_colaborador_fazenda 	int NOT NULL AUTO_INCREMENT,
	  	fk_fazenda 				int NOT NULL,
	  	fk_usuario 				int NOT NULL,
	  	fk_usuario_cadastrou 	int NOT NULL,
	  	fk_nivel_acesso 	int NOT NULL,
	  	tx_motivo_saida 		varchar(250),
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		datetime NOT NULL default CURDATE(),
	  	dt_remocao 			datetime,
	  	PRIMARY KEY (pk_colaborador_fazenda)
	) 

	CREATE TABLE bovino_fazenda (
        pk_bovino_fazenda 	int NOT NULL AUTO_INCREMENT,
        fk_fazenda 		    int NOT NULL,
        fk_animal 		    int NOT NULL,
        fk_tag_rfid 	            int,
        fk_usuario_cadastrou 	    int NOT NULL,
        tx_obtencao 		        varchar(50) NOT NULL,
        tx_baixa 		    varchar(50) NOT NULL,
        is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
        dt_cadastro 		datetime NOT NULL default CURDATE(),
        dt_baixa 		    datetime,
        PRIMARY KEY (pk_bovino_fazenda)
    )
	
/*===================================== ANIMAL ======================================*/

    CREATE TABLE bovino (
	  	pk_bovino 	int NOT NULL AUTO_INCREMENT,
	  	fk_bovino_matriz_femea 		int NOT NULL,
	  	fk_bovino_matriz_macho 		int NOT NULL,
	  	fk_raca 	                int NOT NULL,
	  	fk_usuario_cadastrou 	    int NOT NULL,
	  	tx_sexo 		            varchar(1),
	  	dt_nascimento 		        date,
	  	tx_grau_sangue 		        varchar(50),
	  	is_inseminacao 			tinyint(1) NOT NULL DEFAULT '1',
	  	tx_avaliacao 			varchar(500),
	  	is_ativa 			    tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		    datetime NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_bovino)
	)

	CREATE TABLE foto_bovino (
        pk_foto_bovino 	int NOT NULL AUTO_INCREMENT,
        fk_bovino 			    int NOT NULL,
        fk_usuario_cadastrou 	int NOT NULL,
        bt_foto_bovino 	        LONGBLOB NOT NULL,
        is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
        dt_cadastro 		date NOT NULL default CURDATE(),
        PRIMARY KEY (pk_foto_bovino)
    )

    CREATE TABLE descarte_bovino (
        pk_descarte_bovino 	int NOT NULL AUTO_INCREMENT,
        fk_animal_fazenda 		int NOT NULL,
        fk_usuario_cadastrou 	    int NOT NULL,
        dt_perca 		        date,
        tx_motivo 		        varchar(500),
        tx_observacao 		        varchar(500),
        is_ativa 			    tinyint(1) NOT NULL DEFAULT '1',
        dt_cadastro 		    datetime NOT NULL default CURDATE(),
        PRIMARY KEY (pk_descarte_bovino)
    )

    CREATE TABLE pesagem_bovino (
        pk_pesagem_bovino 	int NOT NULL AUTO_INCREMENT,
        fk_animal_fazenda 		int NOT NULL,
        fk_usuario_cadastrou 	    int NOT NULL,
        dt_pesagem 		        date,
        nr_peso 		        double,
        dt_cadastro 		    datetime NOT NULL default CURDATE(),
        PRIMARY KEY (pk_pesagem_bovino)
    )

    CREATE TABLE vacinacao_bovino (
        pk_vacinacao_bovino 	int NOT NULL AUTO_INCREMENT,
        fk_animal_fazenda 		int NOT NULL,
        fk_vacina 	            int NOT NULL,
        fk_usuario_cadastrou 	    int NOT NULL,
        tx_motivo 		        varchar(500),
        dt_vacinacao 		    date,
        dt_cadastro 		    datetime NOT NULL default CURDATE(),
        PRIMARY KEY (pk_vacinacao_bovino)
    )

/*=================================== NEGOCIACOES ===================================*/

    CREATE TABLE compra (
        pk_compra 	int NOT NULL AUTO_INCREMENT,
        fk_animal_fazenda 				int NOT NULL,
        fk_usuario_cadastrou 	int NOT NULL,
        nr_pesagem 	        double NOT NULL,
        nr_valor 	        double NOT NULL,
        nr_valor_arroba 	double NOT NULL,
        is_pesagem_estimada 	tinyint(1) NOT NULL DEFAULT '1',
        is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
        dt_cadastro 		datetime NOT NULL default CURDATE(),
        dt_compra 			date,
        PRIMARY KEY (pk_compra)
    )


    CREATE TABLE venda (
        pk_venda 	int NOT NULL AUTO_INCREMENT,
        fk_animal_fazenda 				int NOT NULL,
        fk_usuario_cadastrou 	int NOT NULL,
        nr_pesagem 	        double NOT NULL,
        nr_valor 	        double NOT NULL,
        nr_valor_arroba 	double NOT NULL,
        is_pesagem_estimada 	tinyint(1) NOT NULL DEFAULT '1',
        is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
        dt_cadastro 		datetime NOT NULL default CURDATE(),
        dt_venda 			date,
        PRIMARY KEY (pk_venda)
    )


/*=================================== INVENTARIO ====================================*/


    CREATE TABLE lote_teg_RFID (
	  	pk_lote_tag 	int NOT NULL AUTO_INCREMENT,
	  	fk_fazenda 				int NOT NULL,
	  	fk_usuario_cadastrou 	int NOT NULL,
	  	nr_unidades 	int NOT NULL,
	  	nr_valor_pago 	double NOT NULL,
	  	is_metalica 			tinyint(1) NOT NULL DEFAULT '1',
	  	is_tamp_proof 			tinyint(1) NOT NULL DEFAULT '1',
	  	tx_frequencia_operacao 	varchar(5) NOT NULL,
	  	tx_modelo_leitura       varchar(10) NOT NULL,
	  	tx_senha_lote 	        varchar(150) NOT NULL,
	  	tx_observacao_resumo 	varchar(500) NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		datetime NOT NULL default CURDATE(),
	  	dt_remocao 			datetime,
	  	PRIMARY KEY (pk_lote_tag)
	)


	CREATE TABLE tag_rfid (
        pk_tag_rfid 	int NOT NULL AUTO_INCREMENT,
        fk_lote_tag 				int NOT NULL,
        fk_usuario_cadastrou 	int NOT NULL,
        tx_codigo_EPC 	int NOT NULL,
        tx_motivo_remocao 	varchar(500) NOT NULL,
        is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
        dt_cadastro 		datetime NOT NULL default CURDATE(),
        dt_remocao 			datetime,
        PRIMARY KEY (pk_tag_rfid)
    )


    CREATE TABLE vacina (
	  	pk_vacina 	int NOT NULL AUTO_INCREMENT,
	  	fk_fazenda 				int NOT NULL,
	  	fk_usuario_cadastrou 	int NOT NULL,
	  	tx_nome_vacina 	varchar(150) NOT NULL,
	  	tx_nome_lote_vacina 	varchar(100) NOT NULL,
	  	nr_unidades 	int NOT NULL,
	  	nr_custo 	double NOT NULL,
	  	is_registrada_indagro 			tinyint(1) NOT NULL DEFAULT '1',
	  	is_obrigatoria 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_vencimento 			varchar(10),
	  	tx_observacao 	varchar(500) NOT NULL,
	  	is_ativa 			tinyint(1) NOT NULL DEFAULT '1',
	  	dt_cadastro 		datetime NOT NULL default CURDATE(),
	  	PRIMARY KEY (pk_vacina)
	)


/*====================================================================================================================*/
          /*======================================== ALDITORIA LOG ========================================*/
/*====================================================================================================================*/


    CREATE TABLE api_bov_log (
	    thread text NULL,
	    date_of_occurence 			datetime,
	    class text NULL,
	    line_number int4 NULL,
		levell varchar(100) NULL,
		message text NULL,
		stacktrace text NULL,
		user_id text NOT NULL
    )
	
	
	
	
