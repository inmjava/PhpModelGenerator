package br.gov.pr.apucarana.generator.modelgenerator.slqgenerator;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import br.gov.pr.apucarana.generator.modelgenerator.model.Columns;
import br.gov.pr.apucarana.generator.modelgenerator.model.Fk;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.ColumnsDao;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.FkDao;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.factory.ColumnsDaoFactory;
import br.gov.pr.apucarana.generator.modelgenerator.model.dao.factory.FkDaoFactory;


//CREATE TABLE IF NOT EXISTS `fk` (
//  `id` int(11) NOT NULL AUTO_INCREMENT,
//  `tabela` varchar(50) NOT NULL,
//  `fk` varchar(50) NOT NULL,
//  `tabela_dest` varchar(50) NOT NULL,
//  `fk_dest` varchar(50) NOT NULL,
//  `is_extends` varchar(1) NOT NULL,
//  `tabela_nm` varchar(50) NOT NULL,
//  PRIMARY KEY (`id`)
//)


//INSERT INTO `sitepma`.`tb_seg_usuario` (`id`, `login`, `senha`) VALUES (NULL, 'ivan', md5('ivan'));
//
//INSERT INTO `sitepma`.`tb_seg_grupo` (`id`, `nome`) VALUES (NULL, 'admin');
//
//INSERT INTO `sitepma`.`tb_seg_funcao` 	(`id`, `nome`, `link`) 
//VALUES 					(NULL, 'Site', 'site'), 
//					(NULL, 'Gabinete', 'gabinete'), 
//					(NULL, 'Secretaria Saúde', 'secretariasaude'), 
//					(NULL, 'Secretaria Educação', 'secretariaeducacao'), 
//					(NULL, 'Secretaria Esporte e Lazer', 'secretariaesporteelazer');

public class Fks {
	
	public static void main(String[] args) throws Exception {
		
		String code = 
			"CREATE TABLE tb_transporte_ano ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  ano INTEGER UNSIGNED NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_seg_usuario ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  login VARCHAR(40) NULL, " + 
			"  senha VARCHAR(40) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_comprovante_residencia_tipo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_area ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_seg_grupo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  nome VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_representante_titulo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(50) NULL, " + 
			"  url VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_ouvidoria_tipo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(30) NULL, " + 
			"  link VARCHAR(30) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_seg_funcao ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  nome VARCHAR(200) NULL, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_secretaria_classificacao ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_tipo_curso ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_serie ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_video ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  titulo VARCHAR(100) NULL, " + 
			"  sobre VARCHAR(500) NULL, " + 
			"  visualizacoes INTEGER UNSIGNED NULL, " + 
			"  video VARCHAR(50) NULL, " + 
			"  dt_reg DATETIME NULL, " + 
			"  imagem VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_tipo_usuario ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_periodo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_estado ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_escola_tipo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_opcao ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  link VARCHAR(3) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_grau_parentesco ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_multinotas ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  titulo VARCHAR(50) NULL, " + 
			"  multinotas VARCHAR(10000) NULL, " + 
			"  dt_reg DATETIME NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_auditoria ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  usr VARCHAR(100) NULL, " + 
			"  params VARCHAR(10000) NULL, " + 
			"  url VARCHAR(1000) NULL, " + 
			"  ip VARCHAR(15) NULL, " + 
			"  dt_reg DATETIME NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_noticia_estado ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  nome INTEGER UNSIGNED NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_multifotos ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  titulo VARCHAR(200) NULL, " + 
			"  descricao VARCHAR(500) NULL, " + 
			"  imagem VARCHAR(50) NULL, " + 
			"  credito VARCHAR(50) NULL, " + 
			"  ordem INTEGER UNSIGNED NULL, " + 
			"  tipo VARCHAR(1) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_modulo_classificacao ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(30) NOT NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_multifotos_chamadas ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  descricao VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_acesso_rapido ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  titulo VARCHAR(50) NULL, " + 
			"  link VARCHAR(100) NULL, " + 
			"  PRIMARY KEY(id) " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_modulo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_modulo_classificacao INTEGER UNSIGNED NOT NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_modulo_FKIndex1(cd_modulo_classificacao), " + 
			"  FOREIGN KEY(cd_modulo_classificacao) " + 
			"    REFERENCES tb_modulo_classificacao(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_menu ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_menu INTEGER UNSIGNED NULL, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(100) NULL, " + 
			"  url VARCHAR(500) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_menu_FKIndex1(cd_modulo), " + 
			"  INDEX tb_menu_FKIndex2(cd_menu), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_menu) " + 
			"    REFERENCES tb_menu(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_mais_informacoes ( " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  titulo VARCHAR(100) NULL, " + 
			"  descricao VARCHAR(500) NULL, " + 
			"  PRIMARY KEY(cd_modulo), " + 
			"  INDEX tb_mais_informacoes_FKIndex1(cd_modulo), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_escola ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_transporte_escola_tipo INTEGER UNSIGNED NOT NULL, " + 
			"  descricao VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_transporte_escola_FKIndex1(cd_transporte_escola_tipo), " + 
			"  FOREIGN KEY(cd_transporte_escola_tipo) " + 
			"    REFERENCES tb_transporte_escola_tipo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_enquete ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_enquete_FKIndex1(cd_modulo), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_opcoes ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_enquete INTEGER UNSIGNED NOT NULL, " + 
			"  votos INTEGER UNSIGNED NOT NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_opcoes_FKIndex1(cd_enquete), " + 
			"  FOREIGN KEY(cd_enquete) " + 
			"    REFERENCES tb_enquete(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_ouvidoria ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_ouvidoria_tipo INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(50) NULL, " + 
			"  telefone VARCHAR(50) NULL, " + 
			"  endereco VARCHAR(200) NULL, " + 
			"  email VARCHAR(50) NULL, " + 
			"  mensagem VARCHAR(2000) NULL, " + 
			"  resposta VARCHAR(2000) NULL, " + 
			"  estado VARCHAR(1) NULL, " + 
			"  dt_reg DATETIME NULL, " + 
			"  dt_res DATETIME NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_ouvidoria_FKIndex1(cd_ouvidoria_tipo), " + 
			"  FOREIGN KEY(cd_ouvidoria_tipo) " + 
			"    REFERENCES tb_ouvidoria_tipo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_noticia_pos ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(50) NOT NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_noticia_pos_FKIndex1(cd_modulo), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_comentarios ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_enquete INTEGER UNSIGNED NOT NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_comentarios_FKIndex1(cd_enquete), " + 
			"  FOREIGN KEY(cd_enquete) " + 
			"    REFERENCES tb_enquete(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_site ( " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  PRIMARY KEY(cd_modulo), " + 
			"  INDEX tb_site_FKIndex1(cd_modulo), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_banner_pos ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(30) NOT NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_banner_pos_FKIndex1(cd_modulo), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_banner ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_banner_pos INTEGER UNSIGNED NOT NULL, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  titulo VARCHAR(100) NULL, " + 
			"  link VARCHAR(500) NULL, " + 
			"  imagem VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_banner_FKIndex1(cd_modulo), " + 
			"  INDEX tb_banner_FKIndex2(cd_banner_pos), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_banner_pos) " + 
			"    REFERENCES tb_banner_pos(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_seg_grupo_funcao ( " + 
			"  cd_seg_grupo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_seg_funcao INTEGER UNSIGNED NOT NULL, " + 
			"  PRIMARY KEY(cd_seg_grupo, cd_seg_funcao), " + 
			"  INDEX tb_seg_grupo_funcao_FKIndex1(cd_seg_grupo), " + 
			"  INDEX tb_seg_grupo_funcao_FKIndex2(cd_seg_funcao), " + 
			"  FOREIGN KEY(cd_seg_grupo) " + 
			"    REFERENCES tb_seg_grupo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_seg_funcao) " + 
			"    REFERENCES tb_seg_funcao(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_secretaria ( " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_secretaria_classificacao INTEGER UNSIGNED NOT NULL, " + 
			"  cor VARCHAR(7) NOT NULL, " + 
			"  nome VARCHAR(100) NULL, " + 
			"  url VARCHAR(200) NULL, " + 
			"  PRIMARY KEY(cd_modulo), " + 
			"  INDEX tb_secretaria_FKIndex1(cd_modulo), " + 
			"  INDEX tb_secretaria_FKIndex2(cd_secretaria_classificacao), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_secretaria_classificacao) " + 
			"    REFERENCES tb_secretaria_classificacao(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_sub_modulo ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_menu INTEGER UNSIGNED NOT NULL, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  descricao VARCHAR(5000) NULL, " + 
			"  credito_fotos VARCHAR(100) NULL, " + 
			"  url VARCHAR(100) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_sub_modulo_FKIndex1(cd_modulo), " + 
			"  INDEX tb_sub_modulo_FKIndex2(cd_menu), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_menu) " + 
			"    REFERENCES tb_menu(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_seg_grupo_usuario ( " + 
			"  cd_seg_grupo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_seg_usuario INTEGER UNSIGNED NOT NULL, " + 
			"  PRIMARY KEY(cd_seg_grupo, cd_seg_usuario), " + 
			"  INDEX tb_seg_grupo_usuario_FKIndex1(cd_seg_usuario), " + 
			"  INDEX tb_seg_grupo_usuario_FKIndex2(cd_seg_grupo), " + 
			"  FOREIGN KEY(cd_seg_usuario) " + 
			"    REFERENCES tb_seg_usuario(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_seg_grupo) " + 
			"    REFERENCES tb_seg_grupo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_representante ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_representante_titulo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_menu INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(100) NULL, " + 
			"  curriculo VARCHAR(3000) NULL, " + 
			"  foto VARCHAR(50) NULL, " + 
			"  int_curriculo VARCHAR(1000) NULL, " + 
			"  artigo_definido VARCHAR(1) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_representante_FKIndex3(cd_menu), " + 
			"  INDEX tb_representante_FKIndex3(cd_representante_titulo), " + 
			"  INDEX tb_representante_FKIndex3(cd_modulo), " + 
			"  FOREIGN KEY(cd_menu) " + 
			"    REFERENCES tb_menu(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_representante_titulo) " + 
			"    REFERENCES tb_representante_titulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_noticia ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_noticia_estado INTEGER UNSIGNED NOT NULL, " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_noticia_pos INTEGER UNSIGNED NOT NULL, " + 
			"  assunto VARCHAR(50) NULL, " + 
			"  titulo VARCHAR(100) NULL, " + 
			"  linha_fina VARCHAR(500) NULL, " + 
			"  autor VARCHAR(50) NULL, " + 
			"  tags VARCHAR(100) NULL, " + 
			"  descricao VARCHAR(15000) NULL, " + 
			"  dt_reg DATETIME NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_noticia_FKIndex2(cd_noticia_pos), " + 
			"  INDEX tb_noticia_FKIndex3(cd_noticia_estado), " + 
			"  INDEX tb_noticia_FKIndex3(cd_modulo), " + 
			"  FOREIGN KEY(cd_noticia_pos) " + 
			"    REFERENCES tb_noticia_pos(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_noticia_estado) " + 
			"    REFERENCES tb_noticia_estado(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_transporte_usuario ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_transporte_estado INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_grau_parentesco INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_comprovante_residencia_tipo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_escola_ano_anterior INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_serie_ano_anterior INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_opcao INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_escola INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_tipo_curso INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_periodo INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_serie INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_tipo_usuario INTEGER UNSIGNED NOT NULL, " + 
			"  cd_transporte_area INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(200) NULL, " + 
			"  endereco VARCHAR(200) NULL, " + 
			"  numero INTEGER UNSIGNED NULL, " + 
			"  bairro VARCHAR(200) NULL, " + 
			"  telefone1 VARCHAR(14) NULL, " + 
			"  telefone2 VARCHAR(14) NULL, " + 
			"  deficiente VARCHAR(1) NULL, " + 
			"  tipo_deficiencia VARCHAR(200) NULL, " + 
			"  turma VARCHAR(1) NULL, " + 
			"  itinerario VARCHAR(1000) NULL, " + 
			"  obs VARCHAR(1000) NULL, " + 
			"  dt_reg DATETIME NULL, " + 
			"  distancia_escola_metros INTEGER UNSIGNED NULL, " + 
			"  turma_ano_anterior VARCHAR(1) NULL, " + 
			"  nome_titular_comprovante_residencia VARCHAR(200) NULL, " + 
			"  escola_outro_municipio VARCHAR(200) NULL, " + 
			"  login VARCHAR(200) NULL, " + 
			"  foto VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_transporte_usuario_FKIndex2(cd_transporte_area), " + 
			"  INDEX tb_transporte_usuario_FKIndex3(cd_transporte_tipo_usuario), " + 
			"  INDEX tb_transporte_usuario_FKIndex4(cd_transporte_serie), " + 
			"  INDEX tb_transporte_usuario_FKIndex5(cd_transporte_periodo), " + 
			"  INDEX tb_transporte_usuario_FKIndex6(cd_transporte_tipo_curso), " + 
			"  INDEX tb_transporte_usuario_FKIndex7(cd_transporte_escola), " + 
			"  INDEX tb_transporte_usuario_FKIndex9(cd_transporte_opcao), " + 
			"  INDEX tb_transporte_usuario_FKIndex10(cd_transporte_serie_ano_anterior), " + 
			"  INDEX tb_transporte_usuario_FKIndex11(cd_transporte_escola_ano_anterior), " + 
			"  INDEX tb_transporte_usuario_FKIndex12(cd_transporte_comprovante_residencia_tipo), " + 
			"  INDEX tb_transporte_usuario_FKIndex12(cd_transporte_grau_parentesco), " + 
			"  INDEX tb_transporte_usuario_FKIndex13(cd_transporte_estado), " + 
			"  FOREIGN KEY(cd_transporte_area) " + 
			"    REFERENCES tb_transporte_area(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_tipo_usuario) " + 
			"    REFERENCES tb_transporte_tipo_usuario(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_serie) " + 
			"    REFERENCES tb_transporte_serie(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_periodo) " + 
			"    REFERENCES tb_transporte_periodo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_tipo_curso) " + 
			"    REFERENCES tb_transporte_tipo_curso(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_escola) " + 
			"    REFERENCES tb_transporte_escola(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_opcao) " + 
			"    REFERENCES tb_transporte_opcao(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_serie_ano_anterior) " + 
			"    REFERENCES tb_transporte_serie(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_escola_ano_anterior) " + 
			"    REFERENCES tb_transporte_escola(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_comprovante_residencia_tipo) " + 
			"    REFERENCES tb_transporte_comprovante_residencia_tipo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_grau_parentesco) " + 
			"    REFERENCES tb_transporte_grau_parentesco(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION, " + 
			"  FOREIGN KEY(cd_transporte_estado) " + 
			"    REFERENCES tb_transporte_estado(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_sub_modulo_videos ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_sub_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_sub_modulo_videos_FKIndex1(cd_sub_modulo), " + 
			"  FOREIGN KEY(cd_sub_modulo) " + 
			"    REFERENCES tb_sub_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_gabinete ( " + 
			"  cd_modulo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cor VARCHAR(7) NOT NULL, " + 
			"  cor2 VARCHAR(7) NULL, " + 
			"  PRIMARY KEY(cd_modulo), " + 
			"  INDEX tb_gabinete_FKIndex1(cd_modulo), " + 
			"  FOREIGN KEY(cd_modulo) " + 
			"    REFERENCES tb_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_sub_modulo_imagens ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_sub_modulo INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_sub_modulo_imagens_FKIndex1(cd_sub_modulo), " + 
			"  FOREIGN KEY(cd_sub_modulo) " + 
			"    REFERENCES tb_sub_modulo(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_eventos_secretaria ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_secretaria INTEGER UNSIGNED NOT NULL, " + 
			"  descricao VARCHAR(100) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_eventos_secretaria_FKIndex1(cd_secretaria), " + 
			"  FOREIGN KEY(cd_secretaria) " + 
			"    REFERENCES tb_secretaria(cd_modulo) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_noticia_videos ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_noticia INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_noticia_videos_FKIndex1(cd_noticia), " + 
			"  FOREIGN KEY(cd_noticia) " + 
			"    REFERENCES tb_noticia(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); " + 
			" " + 
			"CREATE TABLE tb_noticia_fotos ( " + 
			"  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " + 
			"  cd_noticia INTEGER UNSIGNED NOT NULL, " + 
			"  nome VARCHAR(50) NULL, " + 
			"  credito VARCHAR(50) NULL, " + 
			"  PRIMARY KEY(id), " + 
			"  INDEX tb_noticia_fotos_FKIndex1(cd_noticia), " + 
			"  FOREIGN KEY(cd_noticia) " + 
			"    REFERENCES tb_noticia(id) " + 
			"      ON DELETE NO ACTION " + 
			"      ON UPDATE NO ACTION " + 
			"); ";
		
		List<String> tabela = new LinkedList<String>();
		List<String> fks = new LinkedList<String>();
		List<String> tabela_dest = new LinkedList<String>();
		
		String[] split1 = code.split("PRIMARY KEY");
		for (int i = 0; i < split1.length; i++) {
			String split1v = split1[i];
			if(split1v.contains("INDEX")){
				String[] split21 = split1v.split("INDEX ");
				for (int j = 0; j < split21.length; j++) {
					String split2v = split21[j];
					if(split2v.contains("FKIndex")){
						String v_tabela = split2v.split("FKIndex")[0];
						v_tabela = v_tabela.substring(0, v_tabela.length() - 1);
						if(v_tabela.contains("has_tb_")){
							v_tabela = v_tabela.split("has_tb_")[0] + v_tabela.split("has_tb_")[1];
						}
						tabela.add(v_tabela);
					}
				}
				String[] split22 = split1v.split("FOREIGN ");
				for (int j = 0; j < split22.length; j++) {
					String split2v = split22[j];
					if(split2v.contains("KEY(")){
						String v_fk = split2v.split("KEY\\(")[1];
						v_fk = v_fk.split("\\)")[0];
						fks.add(v_fk);
					}
				}
				String[] split23 = split1v.split("REFER"); // 
				for (int j = 0; j < split23.length; j++) {
					String split2v = split23[j];
					if(split2v.contains("ENCES ")){
						String v_tabela_dest = split2v.split("ENCES ")[1];
						v_tabela_dest = v_tabela_dest.split("\\(")[0];
						tabela_dest.add(v_tabela_dest);
					}
				}
			}
		}
		
		for (int i = 0; i < tabela.size(); i++) {
			String sql = "INSERT INTO `fk` (`id`, `tabela`, `fk`, `tabela_dest`, `fk_dest`, `is_extends`) VALUES (null, '";
			sql += tabela.get(i);
			sql += "', '";
			sql += fks.get(i);
			sql += "', '";
			sql += tabela_dest.get(i);
			
			ColumnsDao columnsDao = ColumnsDaoFactory.createColumnsDao();
			Columns example = new Columns();
			example.setTable_name(tabela_dest.get(i));
			example.setColumn_key("PRI");
			Collection<Columns> columns = columnsDao.listar(example);
			
			for (Iterator<Columns> iterator = columns.iterator(); iterator.hasNext();) {

				String sql2 = sql;
				sql2 += "', '";
				Columns columns2 = (Columns) iterator.next();
				sql2 += columns2.getColumn_name();
				sql2 += "', '";
				sql2 += "N";
				sql2 += "');";
				
				System.out.println(sql2);
				
			}
		}
		
		
		FkDao fk = FkDaoFactory.createFkDao();
		Collection<Fk> listFk = fk.listar();
		
		for (Fk fk2 : listFk) {
			for (Fk fk3 : listFk) {
				if(fk2.getTabela().equals(fk3.getTabela()) && !fk2.getTabela_dest().equals(fk3.getTabela_dest())){
					System.out.println("UPDATE fk SET tabela_nm = '" + fk3.getTabela_dest() + "' WHERE fk.id=" + fk2.getId() + ";");
				}
			}
		}
		
		System.out.println("UPDATE `fk` SET is_extends = 'S' WHERE tabela in ('tb_gabinete', 'tb_secretaria', 'tb_site') AND tabela_dest = 'tb_modulo';");
		System.out.println("UPDATE `fk` SET tabela_nm = null WHERE (tabela = 'tb_menu' and fk = 'cd_modulo') OR (tabela = 'tb_menu' AND fk = 'cd_menu') OR (tabela = 'tb_banner' AND fk = 'cd_banner_pos')  OR (tabela = 'tb_banner' AND fk = 'cd_modulo') OR (tabela = 'tb_noticia' AND fk = 'cd_noticia_pos') OR (tabela = 'tb_noticia' AND fk = 'cd_modulo') OR (tabela = 'tb_representante' AND fk = 'cd_modulo') OR (tabela = 'tb_representante' AND fk = 'cd_titulo') OR (tabela = 'tb_representante' AND fk = 'cd_titulo');");
		
	}
}
