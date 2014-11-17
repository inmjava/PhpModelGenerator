package br.gov.pr.apucarana.generator.modelgenerator.templates;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Parametros;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Coluna;

public class MapperTemplate {
  protected static String nl;
  public static synchronized MapperTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    MapperTemplate result = new MapperTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?php" + NL + "/**" + NL + " * version 1.0" + NL + " */" + NL + " " + NL + "/**" + NL + " * ";
  protected final String TEXT_2 = " data mapper" + NL + " *" + NL + " * Implementa o design pattern Data Mapper:" + NL + " * http://www.martinfowler.com/eaaCatalog/dataMapper.html" + NL + " * " + NL + " * @uses       ";
  protected final String TEXT_3 = NL + " * @subpackage Model" + NL + " */" + NL + "class ";
  protected final String TEXT_4 = " {" + NL + "    /**" + NL + "     * @var Zend_Db_Table_Abstract" + NL + "     */" + NL + "    protected $_dbTable;" + NL + "" + NL + "    /**" + NL + "     * Especifica uma instância Zend_Db_Table, ela será utilizada nas operações com dados" + NL + "     * " + NL + "     * @param  Zend_Db_Table_Abstract $dbTable " + NL + "     * @return ";
  protected final String TEXT_5 = NL + "     */" + NL + "    public function setDbTable($dbTable) {" + NL + "        if (is_string($dbTable)) {" + NL + "            $dbTable = new $dbTable();" + NL + "        }" + NL + "        if (!$dbTable instanceof Zend_Db_Table_Abstract) {" + NL + "            throw new Exception(\"Gateway Inválido\");" + NL + "        }" + NL + "        $this->_dbTable = $dbTable;" + NL + "        return $this;" + NL + "    }" + NL + "" + NL + "    /**" + NL + "     * Obtem a instância de um Zend_Db_Table registrada" + NL + "     *" + NL + "     * Carrega uma instância ";
  protected final String TEXT_6 = " se não existir uma registrada (Lazy Load)" + NL + "     * " + NL + "     * @return Zend_Db_Table_Abstract" + NL + "     */" + NL + "    public function getDbTable() {" + NL + "        if (null === $this->_dbTable) {" + NL + "            $this->setDbTable(\"";
  protected final String TEXT_7 = "\");" + NL + "        }" + NL + "        return $this->_dbTable;" + NL + "    }" + NL + "    " + NL + "    /**" + NL + "     * Insere uma instância de ";
  protected final String TEXT_8 = NL + "     * " + NL + "     * @param  ";
  protected final String TEXT_9 = " $object" + NL + "     * @return void" + NL + "     */" + NL + "    public function insert(";
  protected final String TEXT_10 = " $object) {" + NL + "        $data = array(" + NL + "        \t";
  protected final String TEXT_11 = NL + "\t\t\t\t\"";
  protected final String TEXT_12 = "\" => $object->";
  protected final String TEXT_13 = "()," + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\"";
  protected final String TEXT_15 = "\" => $object->";
  protected final String TEXT_16 = "()," + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\"";
  protected final String TEXT_18 = "\" => ($object->";
  protected final String TEXT_19 = "() == null) ? null : $object->";
  protected final String TEXT_20 = "()->";
  protected final String TEXT_21 = "(), " + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "        );";
  protected final String TEXT_23 = NL + "        $this->tableRow2ModelObject($this->getDbTable()->insert($data), $object);";
  protected final String TEXT_24 = NL + "        $object->setPk($this->getDbTable()->insert($data));";
  protected final String TEXT_25 = NL + "    }" + NL + "    " + NL + "\t/**" + NL + "     * Atualiza uma instância de ";
  protected final String TEXT_26 = NL + "     * " + NL + "     * @param  ";
  protected final String TEXT_27 = " $object" + NL + "     * @return void" + NL + "     */" + NL + "    public function update(";
  protected final String TEXT_28 = " $object) {";
  protected final String TEXT_29 = NL + "    " + NL + "\t\t// A entidade ";
  protected final String TEXT_30 = " não possui campos para serem atualizados" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_31 = NL + "        $data = array(" + NL + "        \t";
  protected final String TEXT_32 = NL + "\t\t\t\t\"";
  protected final String TEXT_33 = "\" => $object->";
  protected final String TEXT_34 = "()," + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\"";
  protected final String TEXT_36 = "\" => ($object->";
  protected final String TEXT_37 = "() == null) ? null : $object->";
  protected final String TEXT_38 = "()->";
  protected final String TEXT_39 = "(), " + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "        );" + NL + "      \t$this->getDbTable()->update($data, array(" + NL + "\t    \t";
  protected final String TEXT_41 = NL + "\t  \t\t\"";
  protected final String TEXT_42 = " = ?\" => $object->";
  protected final String TEXT_43 = "()," + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\"";
  protected final String TEXT_45 = " = ?\" => ($object->";
  protected final String TEXT_46 = "() == null) ? null : $object->";
  protected final String TEXT_47 = "()->";
  protected final String TEXT_48 = "(), " + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "        ));";
  protected final String TEXT_50 = NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t* Deleta uma instância de ";
  protected final String TEXT_51 = NL + "\t* @param ";
  protected final String TEXT_52 = " $object" + NL + "\t* @return void" + NL + "\t*/" + NL + "\tpublic function delete(";
  protected final String TEXT_53 = " $object) {" + NL + "    \t$this->getDbTable()->delete(array(" + NL + "\t    \t";
  protected final String TEXT_54 = NL + "\t  \t\t\"";
  protected final String TEXT_55 = " = ?\" => $object->";
  protected final String TEXT_56 = "()," + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\"";
  protected final String TEXT_58 = " = ?\" => ($object->";
  protected final String TEXT_59 = "() == null) ? null : $object->";
  protected final String TEXT_60 = "()->";
  protected final String TEXT_61 = "(), " + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "        ));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t* Deleta um grupo de instância instância de ";
  protected final String TEXT_63 = " de acordo com " + NL + "\t* a cláusula where." + NL + "\t* " + NL + "\t* @param $where" + NL + "\t* @return void" + NL + "\t*/" + NL + "\tpublic function deleteWhere($where) {" + NL + "    \t$this->getDbTable()->delete($where);" + NL + "\t}" + NL + "" + NL + "    /**" + NL + "     * Procura uma instância de ";
  protected final String TEXT_64 = " pelo id" + NL + "     * " + NL + "     * @param  ";
  protected final String TEXT_65 = " $id  " + NL + "     * @return ";
  protected final String TEXT_66 = NL + "     */" + NL + "    public function find(";
  protected final String TEXT_67 = "$id, ";
  protected final String TEXT_68 = " $object) {";
  protected final String TEXT_69 = NL + "        $data = array(" + NL + "        \t";
  protected final String TEXT_70 = NL + "\t  \t\t\"";
  protected final String TEXT_71 = " = ?\" => $id[\"";
  protected final String TEXT_72 = "\"]," + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\"";
  protected final String TEXT_74 = "\" => $id[\"";
  protected final String TEXT_75 = "\"]->";
  protected final String TEXT_76 = "(), " + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "        );" + NL + "    \t$result = $this->getDbTable()->find($data);";
  protected final String TEXT_78 = NL + "    \t$result = $this->getDbTable()->find($id);";
  protected final String TEXT_79 = NL + "        if (0 == count($result)) {" + NL + "            return ;" + NL + "        }" + NL + "        $row = $result->current();" + NL + "        $this->tableRow2ModelObject($row, $object);" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t* Traz todos os registros" + NL + "\t* " + NL + "\t* @return array" + NL + "\t*/" + NL + "\tpublic function fetchAll() {" + NL + "\t\treturn $this->fetchList(null, null, null, null);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t* Traz todos os registros, método utilizado para realizar paginação" + NL + "\t* " + NL + "\t* @param $count Número máximo de registros" + NL + "\t* @param $offset Começa busca a partir do registro de número especificado " + NL + "\t* @return array" + NL + "\t*/" + NL + "\tpublic function fetchAllPg($count=null, $offset=null) {" + NL + "\t\treturn $this->fetchList(null, null, $count, $offset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t* Traz todos os registros que satisfazem os parametros." + NL + "\t* " + NL + "\t* @param $example Objeto com parâmetros especificados, utilizado para busca" + NL + "\t* @param $order Ordenação dos objetos, nome da coluna no banco" + NL + "\t* @param $count Número máximo de registros" + NL + "\t* @param $offset Começa busca a partir do registro de número especificado " + NL + "\t* @return array" + NL + "\t*/" + NL + "\tpublic function fetchList($where=null, $order=null, $count=null, $offset=null) {" + NL + "\t\t$resultSet = $this->getDbTable()->fetchAll($where, $order, $count, $offset);" + NL + "\t\t$entries   = array();" + NL + "\t\tforeach ($resultSet as $row) {" + NL + "\t\t\t$entry = new ";
  protected final String TEXT_80 = "();" + NL + "\t\t\t$entry->setMapper($this);" + NL + "\t\t\t$this->tableRow2ModelObject($row, $entry);" + NL + "\t\t\t$entries[] = $entry;" + NL + "\t\t}" + NL + "\t\treturn $entries;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t* Traz todos os registros que satisfazem os parametros, leva em conta os atributos" + NL + "\t* especificados no parametro $example" + NL + "\t* " + NL + "\t* @param $example Objeto com parâmetros especificados, utilizado para busca" + NL + "\t* @param $order Ordenação dos objetos, nome da coluna no banco" + NL + "\t* @param $count Número máximo de registros" + NL + "\t* @param $offset Começa busca a partir do registro de número especificado" + NL + "\t* @param $additionalWhere parâmetros especificados, utilizado para busca, adicionais aos " + NL + "\t*                         especificados no objeto. Valores especificados neste parâmetro " + NL + "\t*                         prevalecem." + NL + "\t* @return array" + NL + "\t*/" + NL + "\tpublic function fetchListByExample(";
  protected final String TEXT_81 = " $example=null, $order=null, $count=null, $additionalWhere=null) {" + NL + "\t\t$where = $this->exampleToWhere($example);" + NL + "\t\tif($additionalWhere){" + NL + "\t\t\t$where = array_merge($additionalWhere, $where);" + NL + "\t\t}" + NL + "\t\treturn $this->fetchList($where, $order, $count, $offset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Transforma o Objeto em um array where" + NL + "\t * " + NL + "\t * @param ";
  protected final String TEXT_82 = " $example" + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function exampleToWhere(";
  protected final String TEXT_83 = " $example=null){" + NL + "\t\t$where = array(" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t(($example->";
  protected final String TEXT_85 = "() != null) ? \"";
  protected final String TEXT_86 = " = ?\" : \"1 = ?\") => (($example->";
  protected final String TEXT_87 = "() != null) ? $example->";
  protected final String TEXT_88 = "() : \"1\")," + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t(($example->";
  protected final String TEXT_90 = "() != null) ? \"";
  protected final String TEXT_91 = " ";
  protected final String TEXT_92 = " ?\" : \"1 = ?\") => (($example->";
  protected final String TEXT_93 = "() != null) ? $example->";
  protected final String TEXT_94 = "() : \"1\")," + NL + "\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t(($example->";
  protected final String TEXT_96 = "() != null) ? \"";
  protected final String TEXT_97 = " ";
  protected final String TEXT_98 = " ?\" : \"1 = ?\") => (($example->";
  protected final String TEXT_99 = "() != null) ? $example->";
  protected final String TEXT_100 = "()->";
  protected final String TEXT_101 = "() : \"1\")," + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t);" + NL + "\t\treturn $where;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Conta o número de registros da tabela de acordo com a cláusula where." + NL + "\t * " + NL + "\t * @param $where condição de contagem" + NL + "\t * @return int resultado da contagem" + NL + "\t */" + NL + "\tpublic function count($where=null){" + NL + "\t\tif($where == null){" + NL + "\t\t\t$where = array();" + NL + "\t\t}else if(!is_array($where)){" + NL + "\t\t\t$where = array($where);" + NL + "\t\t}" + NL + "\t\t$select = $this->getDbTable()->select();" + NL + "        $select->from('";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = "', 'COUNT(*) AS num');" + NL + "        foreach ($where as $k => $v) {" + NL + "        \t// apenas números" + NL + "        \tif(is_int($k)){ " + NL + "        \t\t$select->where($v);" + NL + "        \t}else{" + NL + "        \t\t$select->where($k, $v);" + NL + "        \t}" + NL + "        }" + NL + "        return $this->getDbTable()->fetchRow($select)->num;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Conta o número de registros, leva em conta os atributos" + NL + "\t * especificados no parametro $example" + NL + "\t * " + NL + "\t * @param ";
  protected final String TEXT_105 = " $example" + NL + "\t * @param $additionalWhere parâmetros especificados, utilizado para busca, adicionais aos " + NL + "\t *                         especificados no objeto. Valores especificados neste parâmetro " + NL + "\t *                         prevalecem." + NL + "\t * @return int resultado da contagem" + NL + "\t */" + NL + "\tpublic function countByExample(";
  protected final String TEXT_106 = " $example=null, $additionalWhere=null) {" + NL + "\t\t$where = $this->exampleToWhere($example);" + NL + "\t\tif($additionalWhere){" + NL + "\t\t\t$where = array_merge($additionalWhere, $where);" + NL + "\t\t}" + NL + "\t\treturn $this->count($where);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * Returns an instance of a Zend_Db_Table_Select object." + NL + "     *" + NL + "     * @param bool $withFromPart Whether or not to include the from part of the select based on the table" + NL + "     * @return Zend_Db_Table_Select" + NL + "     */" + NL + "\tpublic function select($withFromPart=null){" + NL + "\t\treturn $this->getDbTable()->select($withFromPart);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * Faz o mapeamento entre um objeto Zend_Db_Table_Row e " + NL + "     * popula os valores correspondentes num objeto " + NL + "     * ";
  protected final String TEXT_107 = "." + NL + "     * " + NL + "     * @param  Zend_Db_Table_Row $row  " + NL + "     * @param  ";
  protected final String TEXT_108 = " $object" + NL + "\t * @return ";
  protected final String TEXT_109 = NL + "     */" + NL + "    private function tableRow2ModelObject($row, $object){" + NL + "\t\t";
  protected final String TEXT_110 = NL + "\t\t$";
  protected final String TEXT_111 = " = new ";
  protected final String TEXT_112 = "();" + NL + "\t\t$";
  protected final String TEXT_113 = "->find($row->";
  protected final String TEXT_114 = ");" + NL + "\t\t";
  protected final String TEXT_115 = NL + "\t\t$object";
  protected final String TEXT_116 = NL + "\t\t\t   ->";
  protected final String TEXT_117 = "($row->";
  protected final String TEXT_118 = ")";
  protected final String TEXT_119 = NL + "\t\t\t   ->";
  protected final String TEXT_120 = "($row->";
  protected final String TEXT_121 = ")";
  protected final String TEXT_122 = NL + "\t\t\t   ->";
  protected final String TEXT_123 = "($";
  protected final String TEXT_124 = ")";
  protected final String TEXT_125 = ";" + NL + "\t}" + NL + "}";

	public String generate(Parametros p)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( p.getNameGateway() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( p.getNameMapper() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( p.getNameMapper() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( p.getNameGateway() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( p.getNameGateway() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_10);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getGetName() : c.getGetName() );
    stringBuffer.append(TEXT_13);
    } 
    for (Coluna c: p.getColunas()) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_16);
    } 
    for (Coluna c: p.getColunasFk()) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( c.getColunaFk().getGetName() );
    stringBuffer.append(TEXT_21);
    } 
    stringBuffer.append(TEXT_22);
     if(p.isArrayPk()){ 
    stringBuffer.append(TEXT_23);
     } else { 
    stringBuffer.append(TEXT_24);
     } 
    stringBuffer.append(TEXT_25);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_28);
     if(!p.hasUpdateMethod()){ 
    stringBuffer.append(TEXT_29);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_30);
     } else { 
    stringBuffer.append(TEXT_31);
    for (Coluna c: p.getColunas()) { 
    stringBuffer.append(TEXT_32);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_34);
    } 
    for (Coluna c: p.getColunasFk()) { if (!c.isColunaFkPk(p.getColunasFkPk())) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( c.getColunaFk().getGetName() );
    stringBuffer.append(TEXT_39);
    } } 
    stringBuffer.append(TEXT_40);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getGetName() : c.getGetName() );
    stringBuffer.append(TEXT_43);
    } 
    for (Coluna c: p.getColunasFkPk()) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( c.getColunaFk().getGetName() );
    stringBuffer.append(TEXT_48);
    } 
    stringBuffer.append(TEXT_49);
     } 
    stringBuffer.append(TEXT_50);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_53);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getGetName() : c.getGetName() );
    stringBuffer.append(TEXT_56);
    } 
    for (Coluna c: p.getColunasFkPk()) { 
    stringBuffer.append(TEXT_57);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( c.getColunaFk().getGetName() );
    stringBuffer.append(TEXT_61);
    } 
    stringBuffer.append(TEXT_62);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( p.getPkTypeOrArray() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( (p.isArrayPk() ? "array " : "") );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_68);
     if(p.isArrayPk()){ 
    stringBuffer.append(TEXT_69);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_70);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( c.getNameCamel() );
    stringBuffer.append(TEXT_72);
    } 
    for (Coluna c: p.getColunasFkPk()) { 
    stringBuffer.append(TEXT_73);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( c.getVarNameCamel() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( c.getColunaFk().getGetName() );
    stringBuffer.append(TEXT_76);
    } 
    stringBuffer.append(TEXT_77);
     } else { 
    stringBuffer.append(TEXT_78);
     } 
    stringBuffer.append(TEXT_79);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_83);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getGetName() : c.getGetName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getGetName() : c.getGetName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getGetName() : c.getGetName() );
    stringBuffer.append(TEXT_88);
    } 
    for (Coluna c: p.getColunas()) { 
    stringBuffer.append(TEXT_89);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( c.getEqualOrLike() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_94);
    } 
    for (Coluna c: p.getColunasFk()) { 
    stringBuffer.append(TEXT_95);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( c.getEqualOrLike() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( c.getColunaFk().getGetName() );
    stringBuffer.append(TEXT_101);
    } 
    stringBuffer.append(TEXT_102);
    stringBuffer.append( p.getNameBanco() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( p.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_109);
    for (Coluna c: p.getColunasFk()) { 
    stringBuffer.append(TEXT_110);
    stringBuffer.append( c.getVarNameCamel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( c.getTabelaFk().getNameModel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( c.getVarNameCamel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_114);
    } 
    stringBuffer.append(TEXT_115);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_116);
    stringBuffer.append( p.hasTabelaExtends() ? p.getTabelaExtends().getFirstPkColumn().getSetName() : c.getSetName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_118);
    } 
    for (Coluna c: p.getColunas()) { 
    stringBuffer.append(TEXT_119);
    stringBuffer.append( c.getSetName() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( c.getNameBd() );
    stringBuffer.append(TEXT_121);
    } 
    for (Coluna c: p.getColunasFk()) { 
    stringBuffer.append(TEXT_122);
    stringBuffer.append( c.getSetNameColunaFk() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( c.getVarNameCamel() );
    stringBuffer.append(TEXT_124);
    } 
    stringBuffer.append(TEXT_125);
    return stringBuffer.toString();
  }
}
