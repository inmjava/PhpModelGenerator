package br.gov.pr.apucarana.generator.modelgenerator.templates;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Parametros;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Coluna;
import br.gov.pr.apucarana.generator.modelgenerator.bean.Tabela;

public class ModelTemplate {
  protected static String nl;
  public static synchronized ModelTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelTemplate result = new ModelTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?php" + NL + "" + NL + "/**" + NL + "  * ";
  protected final String TEXT_2 = " model" + NL + "  *" + NL + "  * Utiliza o padrão Data Mapper para persistir dados." + NL + "  * " + NL + "  * @uses       ";
  protected final String TEXT_3 = NL + "  * @subpackage Model" + NL + "  */" + NL + "class ";
  protected final String TEXT_4 = " ";
  protected final String TEXT_5 = " {" + NL + "\t";
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t * @var ";
  protected final String TEXT_7 = NL + "\t * Primay Key" + NL + "\t */" + NL + "\tprotected $_";
  protected final String TEXT_8 = ";" + NL + "\t";
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @var ";
  protected final String TEXT_10 = NL + "\t */" + NL + "\tprotected $_mapper;" + NL + "\t";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * @var ";
  protected final String TEXT_12 = NL + "\t */" + NL + "\tprotected $_";
  protected final String TEXT_13 = ";" + NL + "\t";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t * @var ";
  protected final String TEXT_16 = NL + "\t * Primay Key";
  protected final String TEXT_17 = NL + "\t */" + NL + "\tprotected $_";
  protected final String TEXT_18 = ";" + NL + "\t";
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t * Constructor" + NL + "\t * " + NL + "\t * @param  array|null $options " + NL + "\t * @return void" + NL + "\t */" + NL + "\tpublic function __construct(array $options = null) {" + NL + "\t\tif (is_array($options)) {" + NL + "\t\t\t$this->setOptions($options);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Overloading: allow property access" + NL + "\t * " + NL + "\t * @param  string $name " + NL + "\t * @param  mixed $value " + NL + "\t * @return void" + NL + "\t */" + NL + "\tpublic function __set($name, $value) {" + NL + "\t\t$method = \"set\" . $name;" + NL + "\t\tif (\"mapper\" == $name || !method_exists($this, $method)) {" + NL + "\t\t\tthrow new Exception(\"Invalid property specified\");" + NL + "\t\t}" + NL + "\t\t$this->$method($value);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Overloading: allow property access" + NL + "\t * " + NL + "\t * @param  string $name " + NL + "\t * @return mixed" + NL + "\t */" + NL + "\tpublic function __get($name) {" + NL + "\t\t$method = \"get\" . $name;" + NL + "\t\tif (\"mapper\" == $name || !method_exists($this, $method)) {" + NL + "\t\t\tthrow new Exception(\"Invalid property specified\");" + NL + "\t\t}" + NL + "\t\treturn $this->$method();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Set object state" + NL + "\t * " + NL + "\t * @param  array $options " + NL + "\t * @return ";
  protected final String TEXT_20 = NL + "\t */" + NL + "\tpublic function setOptions(array $options) {" + NL + "\t\t$methods = get_class_methods($this);" + NL + "\t\tforeach ($options as $key => $value) {" + NL + "\t\t\t$method = \"set\" . ucfirst($key);" + NL + "\t\t\tif (in_array($method, $methods)) {" + NL + "\t\t\t    $this->$method($value);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "    " + NL + "    /**" + NL + "\t * Set primary (Não possui variável como atributo)" + NL + "\t * Código identificador da entidade ";
  protected final String TEXT_21 = NL + "\t * " + NL + "\t * @param ";
  protected final String TEXT_22 = " primary" + NL + "\t * @return ";
  protected final String TEXT_23 = NL + "\t */" + NL + "\tpublic function setPk(";
  protected final String TEXT_24 = "$pk){" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\treturn parent::setPk($pk);" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t$this->setOptions($pk);" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\treturn $this->";
  protected final String TEXT_28 = "($pk);" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Get primary (Não possui variável como atributo)" + NL + "\t * Código identificador da entidade ";
  protected final String TEXT_30 = NL + "\t * Primary Key" + NL + "\t * " + NL + "\t * @return null|";
  protected final String TEXT_31 = NL + "\t */" + NL + "\tpublic function getPk(){" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\treturn parent::getPk();" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\treturn array(" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\"";
  protected final String TEXT_35 = "\" => $this->";
  protected final String TEXT_36 = "()," + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\"";
  protected final String TEXT_38 = "\" => $this->";
  protected final String TEXT_39 = "(), " + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t);" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\treturn $this->";
  protected final String TEXT_42 = "();" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t}" + NL + "\t";
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * Setter da propriedade ";
  protected final String TEXT_45 = NL + "\t * Primary Key" + NL + "\t * " + NL + "\t * @param ";
  protected final String TEXT_46 = " $";
  protected final String TEXT_47 = NL + "\t * @return ";
  protected final String TEXT_48 = NL + "\t */" + NL + "\tpublic function ";
  protected final String TEXT_49 = "($";
  protected final String TEXT_50 = "){" + NL + "\t\t$this->_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Getter da propriedade ";
  protected final String TEXT_53 = NL + "\t * Primary Key" + NL + "\t * " + NL + "\t * @return null|";
  protected final String TEXT_54 = NL + "\t */" + NL + "\tpublic function ";
  protected final String TEXT_55 = "() {" + NL + "\t\treturn $this->_";
  protected final String TEXT_56 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_57 = NL + "\t/**" + NL + "\t * Setter da propriedade ";
  protected final String TEXT_58 = NL + "\t * " + NL + "\t * @param ";
  protected final String TEXT_59 = " $";
  protected final String TEXT_60 = NL + "\t * @return ";
  protected final String TEXT_61 = NL + "\t */" + NL + "\tpublic function ";
  protected final String TEXT_62 = "($";
  protected final String TEXT_63 = "){" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t// Verifica o formato da data em questão " + NL + "\t\t// se for brasileiro (dd/mm/yyyy ou dd/mm/yyyy hh:ii ou dd/mm/yyyy hh:ii:ss)" + NL + "\t\t// converte em datetime (yyyy-mm-dd hh:ii:ss) " + NL + "\t\t// caso contrário" + NL + "\t\t// considera que foi passado um datetime e associa a variável" + NL + "\t\t" + NL + "\t\tlist($d, $m, $a, $h, $i, $s) = split( '[/ :]', $";
  protected final String TEXT_65 = ");" + NL + "    \tif(($d && $m && $a && (strlen($";
  protected final String TEXT_66 = ") == 10) || ($d && $m && $a && $h && $i && strlen($";
  protected final String TEXT_67 = ") == 16) || ($d && $m && $a && $h && $i && $s && strlen($";
  protected final String TEXT_68 = ") == 19))){" + NL + "    \t\tif(!$h){$h = $i = $s = '00';}" + NL + "    \t\tif(!$s){$s = '00';}" + NL + "\t\t\t$";
  protected final String TEXT_69 = " = \"$a-$m-$d $h:$i:$s\";" + NL + "    \t}";
  protected final String TEXT_70 = NL + "\t\t$this->_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ";" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Getter da propriedade ";
  protected final String TEXT_73 = NL + "\t * " + NL + "\t * @return null|";
  protected final String TEXT_74 = NL + "\t */" + NL + "\tpublic function ";
  protected final String TEXT_75 = "() {" + NL + "\t\treturn $this->_";
  protected final String TEXT_76 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_77 = NL + "\t/**" + NL + "\t * Setter da propriedade ";
  protected final String TEXT_78 = NL + "\t * Primay Key";
  protected final String TEXT_79 = NL + "\t * " + NL + "\t * @param ";
  protected final String TEXT_80 = " $";
  protected final String TEXT_81 = NL + "\t * @return ";
  protected final String TEXT_82 = NL + "\t */" + NL + "\tpublic function ";
  protected final String TEXT_83 = "($";
  protected final String TEXT_84 = "){" + NL + "\t\tif (!$";
  protected final String TEXT_85 = " instanceof ";
  protected final String TEXT_86 = ") {" + NL + "            $";
  protected final String TEXT_87 = " = new ";
  protected final String TEXT_88 = "(array(\"";
  protected final String TEXT_89 = "\" => $";
  protected final String TEXT_90 = "));" + NL + "            $";
  protected final String TEXT_91 = " = $";
  protected final String TEXT_92 = "->findFirstByExample();" + NL + "        }" + NL + "\t\t" + NL + "\t\t$this->_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Getter da propriedade ";
  protected final String TEXT_95 = NL + "\t * Primay Key";
  protected final String TEXT_96 = NL + "\t * " + NL + "\t * @return null|";
  protected final String TEXT_97 = NL + "\t */" + NL + "\tpublic function ";
  protected final String TEXT_98 = "() {" + NL + "\t\treturn $this->_";
  protected final String TEXT_99 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_100 = NL + "\t/**" + NL + "\t * Set data mapper" + NL + "\t * " + NL + "\t * @param  mixed $mapper " + NL + "\t * @return ";
  protected final String TEXT_101 = NL + "\t */" + NL + "\tpublic function setMapper($mapper) {" + NL + "\t\t$this->_mapper = $mapper;" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Get data mapper" + NL + "\t *" + NL + "\t * Instancia ";
  protected final String TEXT_102 = " apenas se ainda n�o foi instanciada (Lazy Load)." + NL + "\t * " + NL + "\t * @return ";
  protected final String TEXT_103 = NL + "\t */" + NL + "\tpublic function getMapper() {" + NL + "\t\tif (null === $this->_mapper || !$this->_mapper instanceof ";
  protected final String TEXT_104 = ") {" + NL + "\t\t\t$this->setMapper(new ";
  protected final String TEXT_105 = "());" + NL + "\t\t}" + NL + "\t\treturn $this->_mapper;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_106 = "\t" + NL + "\t/**" + NL + "\t * Lista instâncias ";
  protected final String TEXT_107 = " associadas a " + NL + "\t * ";
  protected final String TEXT_108 = NL + "\t * " + NL + "\t * @param $count Número máximo de registros" + NL + "\t * @param $offset Começa busca a partir do registro de número especificado " + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function list";
  protected final String TEXT_109 = "($count=null, $offset=null, $order=null){" + NL + "\t\t$";
  protected final String TEXT_110 = " = new ";
  protected final String TEXT_111 = "();" + NL + "\t\t$";
  protected final String TEXT_112 = "->";
  protected final String TEXT_113 = "($this);" + NL + "\t\treturn $";
  protected final String TEXT_114 = "->fetchListByExample($";
  protected final String TEXT_115 = ", $order, $count, $offset);" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Obtem o primeiro registro ";
  protected final String TEXT_116 = " associado a " + NL + "\t * ";
  protected final String TEXT_117 = NL + "\t * " + NL + "\t * @return ";
  protected final String TEXT_118 = NL + "\t */" + NL + "\tpublic function findFirst";
  protected final String TEXT_119 = "($offset=null, $order=null) {" + NL + "\t\t$aux = $this->list";
  protected final String TEXT_120 = "(1, $offset, $order);" + NL + "\t\tif($aux == null)" + NL + "\t\t\treturn null;" + NL + "\t\treturn $aux[0];" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Exclui instâncias ";
  protected final String TEXT_121 = " associadas a " + NL + "\t * ";
  protected final String TEXT_122 = NL + "\t * " + NL + "\t * @param $entries um array de objetos ";
  protected final String TEXT_123 = " ou " + NL + "\t * apenas um objeto ";
  protected final String TEXT_124 = NL + "\t * @return ";
  protected final String TEXT_125 = NL + "\t */" + NL + "\tpublic function delete";
  protected final String TEXT_126 = "($entries){" + NL + "\t\tif($entries instanceof ";
  protected final String TEXT_127 = "){" + NL + "\t\t\t$entries = array($entries);" + NL + "\t\t}" + NL + "\t\tforeach($entries as $entry){" + NL + "\t\t\t$entry->";
  protected final String TEXT_128 = "($this);" + NL + "\t\t\t$entry->delete();" + NL + "\t\t}" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Exclui instâncias ";
  protected final String TEXT_129 = " associadas a " + NL + "\t * ";
  protected final String TEXT_130 = NL + "\t * " + NL + "\t * @return ";
  protected final String TEXT_131 = NL + "\t */" + NL + "\tpublic function deleteAll";
  protected final String TEXT_132 = "(){" + NL + "\t\t$this->delete";
  protected final String TEXT_133 = "($this->list";
  protected final String TEXT_134 = "());" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Insere instâncias ";
  protected final String TEXT_135 = " associadas a " + NL + "\t * ";
  protected final String TEXT_136 = NL + "\t * " + NL + "\t * @param $entries um array de objetos ";
  protected final String TEXT_137 = " ou " + NL + "\t * apenas um objeto ";
  protected final String TEXT_138 = NL + "\t * @return ";
  protected final String TEXT_139 = NL + "\t */" + NL + "\tpublic function insert";
  protected final String TEXT_140 = "($entries){" + NL + "\t\tif($entries instanceof ";
  protected final String TEXT_141 = "){" + NL + "\t\t\t$entries = array($entries);" + NL + "\t\t}" + NL + "\t\tforeach($entries as $entry){" + NL + "\t\t\t$entry->";
  protected final String TEXT_142 = "($this);" + NL + "\t\t\t$entry->insert();" + NL + "\t\t}" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Atualiza instâncias ";
  protected final String TEXT_143 = " associadas a " + NL + "\t * ";
  protected final String TEXT_144 = NL + "\t * " + NL + "\t * @param $entries um array de objetos ";
  protected final String TEXT_145 = " ou " + NL + "\t * apenas um objeto ";
  protected final String TEXT_146 = NL + "\t * @return ";
  protected final String TEXT_147 = NL + "\t */" + NL + "\tpublic function update";
  protected final String TEXT_148 = "($entries){" + NL + "\t\t$this->deleteAll";
  protected final String TEXT_149 = "();" + NL + "\t\t$this->insert";
  protected final String TEXT_150 = "($entries);" + NL + "\t\treturn $this;" + NL + "\t}";
  protected final String TEXT_151 = NL + "\t" + NL + "\t/**" + NL + "\t * Lista instâncias ";
  protected final String TEXT_152 = " associadas a " + NL + "\t * ";
  protected final String TEXT_153 = NL + "\t * " + NL + "\t * @param $count Número máximo de registros" + NL + "\t * @param $offset Começa busca a partir do registro de número especificado " + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function list";
  protected final String TEXT_154 = "($count=null, $offset=null, $order=null){" + NL + "\t\t$entries = $this->list";
  protected final String TEXT_155 = "($count, $offset, $order);" + NL + "\t\t$entriesOut = array();" + NL + "\t\tforeach ($entries as $entry) {" + NL + "\t\t\t$entriesOut[] = $entry->";
  protected final String TEXT_156 = "();" + NL + "\t\t}" + NL + "\t\treturn $entriesOut; " + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Obtem o primeiro registro ";
  protected final String TEXT_157 = " associado a " + NL + "\t * ";
  protected final String TEXT_158 = NL + "\t * " + NL + "\t * @return ";
  protected final String TEXT_159 = NL + "\t */" + NL + "\tpublic function findFirst";
  protected final String TEXT_160 = "() {" + NL + "\t\t$aux = $this->list";
  protected final String TEXT_161 = "(1);" + NL + "\t\tif($aux == null)" + NL + "\t\t\treturn null;" + NL + "\t\treturn $aux[0];" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Exclui instâncias ";
  protected final String TEXT_162 = " associadas a " + NL + "\t * ";
  protected final String TEXT_163 = NL + "\t * " + NL + "\t * @param $entries um array de objetos ";
  protected final String TEXT_164 = " ou " + NL + "\t * apenas um objeto ";
  protected final String TEXT_165 = NL + "\t * @return ";
  protected final String TEXT_166 = NL + "\t */" + NL + "\tpublic function delete";
  protected final String TEXT_167 = "($entries){" + NL + "\t\tif($entries instanceof ";
  protected final String TEXT_168 = "){" + NL + "\t\t\t$entries = array($entries);" + NL + "\t\t}" + NL + "\t\t$entriesIn = array();" + NL + "\t\tforeach($entries as $entry){" + NL + "\t\t\t$entryIn = new ";
  protected final String TEXT_169 = "();" + NL + "\t\t\t$entryIn->";
  protected final String TEXT_170 = "($entry)" + NL + "\t\t\t        ->";
  protected final String TEXT_171 = "($this);" + NL + "\t\t\t$entriesIn[] = $entryIn;" + NL + "\t\t}" + NL + "\t\treturn $this->delete";
  protected final String TEXT_172 = "($entriesIn);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Exclui instâncias ";
  protected final String TEXT_173 = " associadas a " + NL + "\t * ";
  protected final String TEXT_174 = NL + "\t * " + NL + "\t * @return ";
  protected final String TEXT_175 = NL + "\t */" + NL + "\tpublic function deleteAll";
  protected final String TEXT_176 = "(){" + NL + "\t\treturn $this->deleteAll";
  protected final String TEXT_177 = "();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Insere instâncias ";
  protected final String TEXT_178 = " associadas a " + NL + "\t * ";
  protected final String TEXT_179 = NL + "\t * " + NL + "\t * @param $entries um array de objetos ";
  protected final String TEXT_180 = " ou " + NL + "\t * apenas um objeto ";
  protected final String TEXT_181 = NL + "\t * @return ";
  protected final String TEXT_182 = NL + "\t */" + NL + "\tpublic function insert";
  protected final String TEXT_183 = "($entries){" + NL + "\t\tif($entries instanceof ";
  protected final String TEXT_184 = "){" + NL + "\t\t\t$entries = array($entries);" + NL + "\t\t}" + NL + "\t\t$entriesIn = array();" + NL + "\t\tforeach($entries as $entry){" + NL + "\t\t\t$entryIn = new ";
  protected final String TEXT_185 = "();" + NL + "\t\t\t$entryIn->";
  protected final String TEXT_186 = "($entry)" + NL + "\t\t\t        ->";
  protected final String TEXT_187 = "($this);" + NL + "\t\t\t$entriesIn[] = $entryIn;" + NL + "\t\t}" + NL + "\t\treturn $this->insert";
  protected final String TEXT_188 = "($entriesIn);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Atualiza instâncias ";
  protected final String TEXT_189 = " associadas a " + NL + "\t * ";
  protected final String TEXT_190 = NL + "\t * " + NL + "\t * @param $entries um array de objetos ";
  protected final String TEXT_191 = " ou " + NL + "\t * apenas um objeto ";
  protected final String TEXT_192 = NL + "\t * @return ";
  protected final String TEXT_193 = NL + "\t */" + NL + "\tpublic function update";
  protected final String TEXT_194 = "($entries){" + NL + "\t\tif($entries instanceof ";
  protected final String TEXT_195 = "){" + NL + "\t\t\t$entries = array($entries);" + NL + "\t\t}" + NL + "\t\t$entriesIn = array();" + NL + "\t\tforeach($entries as $entry){" + NL + "\t\t\t$entryIn = new ";
  protected final String TEXT_196 = "();" + NL + "\t\t\t$entryIn->";
  protected final String TEXT_197 = "($entry)" + NL + "\t\t\t        ->";
  protected final String TEXT_198 = "($this);" + NL + "\t\t\t$entriesIn[] = $entryIn;" + NL + "\t\t}" + NL + "\t\treturn $this->update";
  protected final String TEXT_199 = "($entriesIn);" + NL + "\t}\t" + NL + "\t";
  protected final String TEXT_200 = "\t" + NL + "\t/**" + NL + "\t * Insere o registro corrente" + NL + "\t * " + NL + "\t * @return void" + NL + "\t */" + NL + "\tpublic function insert() {";
  protected final String TEXT_201 = NL + "\t\tparent::getMapper()->insert($this);";
  protected final String TEXT_202 = NL + "\t\t$this->getMapper()->insert($this);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Atualiza o registro corrente" + NL + "\t * " + NL + "\t * @return void" + NL + "\t */" + NL + "\tpublic function update() {";
  protected final String TEXT_203 = NL + "\t\tparent::getMapper()->update($this);";
  protected final String TEXT_204 = NL + "\t\t$this->getMapper()->update($this);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Deleta o registro corrente" + NL + "\t * @return void" + NL + "\t */" + NL + "\tpublic function delete() {" + NL + "\t\t$this->getMapper()->delete($this);";
  protected final String TEXT_205 = NL + "\t\tparent::getMapper()->delete($this);";
  protected final String TEXT_206 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Deleta um conjunto de registros de acordo " + NL + "\t * com a cláusula where" + NL + "\t * " + NL + "\t * @param $where " + NL + "\t * @return void" + NL + "\t */" + NL + "\tpublic function deleteWhere($where) {" + NL + "\t\t$this->getMapper()->deleteWhere($where);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Procura um registro" + NL + "\t *" + NL + "\t * Reinicia o estado da instância se encontrado pelo id" + NL + "\t * " + NL + "\t * @param  ";
  protected final String TEXT_207 = " $id " + NL + "\t * @return ";
  protected final String TEXT_208 = NL + "\t */" + NL + "\tpublic function find(";
  protected final String TEXT_209 = " $id) {";
  protected final String TEXT_210 = NL + "\t\tparent::getMapper()->find($id, $this);" + NL + "\t\t";
  protected final String TEXT_211 = NL + "\t\t$this->getMapper()->find($id, $this);" + NL + "\t\treturn $this;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Obtem o primeiro registro da tabela" + NL + "\t * " + NL + "\t * @return ";
  protected final String TEXT_212 = NL + "\t */" + NL + "\tpublic function findFirst() {" + NL + "\t\t$aux = $this->fetchAllPg(1);" + NL + "\t\tif($aux == null)" + NL + "\t\t\treturn null;" + NL + "\t\treturn $aux[0];" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Traz todos os registros" + NL + "\t * " + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function fetchAll() {";
  protected final String TEXT_213 = NL + "\t\treturn $this->getMapper()->fetchAll();" + NL + "\t\t";
  protected final String TEXT_214 = NL + "\t\t$entries = $this->getMapper()->fetchAll();" + NL + "\t\tforeach ($entries as $entry){" + NL + "\t\t\t$entry->find($entry->getId());" + NL + "\t\t}" + NL + "\t\treturn $entries;";
  protected final String TEXT_215 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Traz todos os registros, método utilizado para realizar paginação" + NL + "\t * " + NL + "\t * @param $count Número máximo de registros" + NL + "\t * @param $offset Começa busca a partir do registro de número especificado " + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function fetchAllPg($count=null, $offset=null) {";
  protected final String TEXT_216 = NL + "\t\treturn $this->getMapper()->fetchAllPg($count, $offset);" + NL + "\t\t";
  protected final String TEXT_217 = NL + "\t\t$entries = $this->getMapper()->fetchAllPg($count, $offset);" + NL + "\t\tforeach ($entries as $entry){" + NL + "\t\t\t$entry->find($entry->getId());" + NL + "\t\t}" + NL + "\t\treturn $entries;";
  protected final String TEXT_218 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Traz todos os registros que satisfazem os parametros." + NL + "\t * " + NL + "\t * @param $example Objeto com parâmetros especificados, utilizado para busca" + NL + "\t * @param $order Ordenação dos objetos, nome da coluna no banco" + NL + "\t * @param $count Número máximo de registros" + NL + "\t * @param $offset Começa busca a partir do registro de número especificado " + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function fetchList($where=null, $order=null, $count=null, $offset=null) {";
  protected final String TEXT_219 = NL + "\t\treturn $this->getMapper()->fetchList($where, $order, $count, $offset);" + NL + "\t\t";
  protected final String TEXT_220 = NL + "\t\t$entries = $this->getMapper()->fetchList($where, $order, $count, $offset);" + NL + "\t\tforeach ($entries as $entry){" + NL + "\t\t\t$entry->find($entry->getId());" + NL + "\t\t}" + NL + "\t\treturn $entries;";
  protected final String TEXT_221 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Traz todos os registros que satisfazem os parametros, leva em conta os atributos" + NL + "\t * especificados no parametro $example" + NL + "\t * " + NL + "\t * @param $example Objeto com parâmetros especificados, utilizado para busca" + NL + "\t * @param $order Ordenação dos objetos, nome da coluna no banco" + NL + "\t * @param $count Número máximo de registros" + NL + "\t * @param $offset Começa busca a partir do registro de número especificado" + NL + "\t * @param $additionalWhere parâmetros especificados, utilizado para busca, adicionais aos " + NL + "\t *                         especificados no objeto. Valores especificados neste parâmetro " + NL + "\t *                         prevalecem. " + NL + "\t * @return array" + NL + "\t */" + NL + "\tpublic function fetchListByExample(";
  protected final String TEXT_222 = " $example=null, $order=null, $count=null, $offset=null, $additionalWhere=null) {";
  protected final String TEXT_223 = NL + "\t\treturn $this->getMapper()->fetchListByExample($example, $order, $count, $offset, $additionalWhere);" + NL + "\t\t";
  protected final String TEXT_224 = NL + "\t\t$entries = $this->getMapper()->fetchListByExample($example, $order, $count, $offset, $additionalWhere);" + NL + "\t\tforeach ($entries as $entry){" + NL + "\t\t\t$entry->find($entry->";
  protected final String TEXT_225 = "());" + NL + "\t\t}" + NL + "\t\treturn $entries;";
  protected final String TEXT_226 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t *  Retorna o primeiro registro que encontrar com os dados do objeto corrente." + NL + "\t *  " + NL + "\t * @param $order Ordenação dos objetos, nome da coluna no banco" + NL + "\t * @param $offset Começa busca a partir do registro de número especificado " + NL + "\t * @param $additionalWhere parâmetros especificados, utilizado para busca, adicionais aos " + NL + "\t *                         especificados no objeto. Valores especificados neste parâmetro " + NL + "\t *                         prevalecem. " + NL + "\t * @return ";
  protected final String TEXT_227 = " ou null se não encontrar nada." + NL + "\t */" + NL + "\tpublic function findFirstByExample($order=null, $offset=null) {" + NL + "\t\t$result = $this->fetchListByExample($this, $order, 1, $offset, $additionalWhere=null);" + NL + "\t\tif(count($result) <= 0)" + NL + "\t\t\treturn null;" + NL + "\t\t$result = $result[0];" + NL + "\t\treturn $result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Conta o número de registros da tabela de acordo com a cláusula where." + NL + "\t * " + NL + "\t * @param $where condição de contagem" + NL + "\t * @return int resultado da contagem" + NL + "\t */" + NL + "\tpublic function count($where=null){" + NL + "\t\treturn $this->getMapper()->count($where);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Conta o número de registros de acordo com os atributos do objeto." + NL + "\t * @param $additionalWhere parâmetros especificados, utilizado para busca, adicionais aos " + NL + "\t *                         especificados no objeto. Valores especificados neste parâmetro " + NL + "\t *                         prevalecem. " + NL + "\t * @return int resultado da contagem" + NL + "\t */" + NL + "\tpublic function countByExample($additionalWhere=null){" + NL + "\t\treturn $this->getMapper()->countByExample($this, $additionalWhere);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * Returns an instance of a Zend_Db_Table_Select object." + NL + "     *" + NL + "     * @param bool $withFromPart Whether or not to include the from part of the select based on the table" + NL + "     * @return Zend_Db_Table_Select" + NL + "     */" + NL + "\tpublic function select($withFromPart=null){" + NL + "\t\treturn $this->getMapper()->select($withFromPart);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Retorna uma string que identifica o objeto" + NL + "\t * " + NL + "\t * @return string" + NL + "\t */" + NL + " \tpublic function __toString() {" + NL + " \t\t$out = \"$";
  protected final String TEXT_228 = "{\";" + NL + " \t\t";
  protected final String TEXT_229 = NL + "\t\t$out .= \"";
  protected final String TEXT_230 = " => \";" + NL + "\t\t$out .= $this->";
  protected final String TEXT_231 = "();" + NL + " \t\t$out .= \" | \";" + NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\t$out .= \"";
  protected final String TEXT_233 = " => \";" + NL + "\t\t$out .= $this->";
  protected final String TEXT_234 = "();" + NL + " \t\t$out .= \" | \";" + NL + "\t\t";
  protected final String TEXT_235 = NL + "\t\t$out .= \"";
  protected final String TEXT_236 = " => \";" + NL + "\t\t$out .=  $this->";
  protected final String TEXT_237 = "();" + NL + " \t\t$out .= \" | \";" + NL + "\t\t";
  protected final String TEXT_238 = NL + " \t\t$out .= \"}\";" + NL + "\t\treturn $out;" + NL + "    }" + NL + "}";

	public String generate(Parametros p)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( p.getNameMapper() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( p.hasTabelaExtends() ? "extends "+p.getTabelaExtends().getNameModel() : "" );
    stringBuffer.append(TEXT_5);
    if(!p.hasTabelaExtends()){for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append( c.getTipo() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( c.getNameCamel() );
    stringBuffer.append(TEXT_8);
    }} 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( p.getNameMapper() );
    stringBuffer.append(TEXT_10);
    for (Coluna c: p.getColunas()) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append( c.getTipo() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( c.getNameCamel() );
    stringBuffer.append(TEXT_13);
    } 
    stringBuffer.append(TEXT_14);
    for (Coluna c: p.getColunasFk()) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append( c.getTabelaFk().getNameModel() );
     if(c.isColunaFkPk(p.getColunasFkPk())) { 
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
    stringBuffer.append( c.getVarNameCamel() );
    stringBuffer.append(TEXT_18);
    } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(p.getPkTypeOrArray(true));
    stringBuffer.append(TEXT_22);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( (p.isArrayPk() ? "array " : "") );
    stringBuffer.append(TEXT_24);
     if(p.hasTabelaExtends()) { 
    stringBuffer.append(TEXT_25);
     } else if(p.isArrayPk()) { 
    stringBuffer.append(TEXT_26);
     } else { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append( (p.getFirstPkColumn().isColunaFkPk(p.getColunasFkPk())) ? p.getFirstPkColumn().getTabelaFk().getSetName() : p.getFirstPkColumn().getSetName() );
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(p.getPkTypeOrArray(true));
    stringBuffer.append(TEXT_31);
     if(p.hasTabelaExtends()) { 
    stringBuffer.append(TEXT_32);
     } else { 
     if(p.isArrayPk()) { 
    stringBuffer.append(TEXT_33);
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_34);
    stringBuffer.append( c.getNameCamel() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_36);
     } 
    for (Coluna c: p.getColunasFkPk()) { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append( c.getTabelaFk().getVarNameCamel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_39);
    } 
    stringBuffer.append(TEXT_40);
     } else { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append( (p.getFirstPkColumn().isColunaFkPk(p.getColunasFkPk())) ? p.getFirstPkColumn().getTabelaFk().getGetName() : p.getFirstPkColumn().getGetName() );
    stringBuffer.append(TEXT_42);
     }} 
    stringBuffer.append(TEXT_43);
    if(!p.hasTabelaExtends()){for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(c.getTipo());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(c.getSetName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append( c.getAttCasted());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(c.getTipo());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(c.getGetName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_56);
    }} 
    for (Coluna c: p.getColunas()) { 
    stringBuffer.append(TEXT_57);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(c.getTipo());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(c.getSetName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_63);
    if(c.getTipo().equals("date")){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(c.getAttCasted());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(c.getTipo());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(c.getGetName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(c.getNameCamel());
    stringBuffer.append(TEXT_76);
    } 
    for (Coluna c: p.getColunasFk()) { 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(c.getVarNameCamel());
     if(c.isColunaFkPk(p.getColunasFkPk())) { 
    stringBuffer.append(TEXT_78);
     } 
    stringBuffer.append(TEXT_79);
    stringBuffer.append(c.getTabelaFk().getNameModel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_81);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(c.getSetNameColunaFk());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(c.getTabelaFk().getNameModel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(c.getTabelaFk().getNameModel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append( c.getColunaFk().getNameCamel() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(c.getAttCasted());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(c.getVarNameCamel());
     if(c.isColunaFkPk(p.getColunasFkPk())) { 
    stringBuffer.append(TEXT_95);
     } 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(c.getTabelaFk().getNameModel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(c.getGetNameColunaFk());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(c.getVarNameCamel());
    stringBuffer.append(TEXT_99);
    } 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(p.getNameMapper());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(p.getNameMapper());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(p.getNameMapper());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(p.getNameMapper());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(p.getNameMapper());
    stringBuffer.append(TEXT_105);
    for (Tabela t: p.getTabelasFk()) { 
    stringBuffer.append(TEXT_106);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append( t.getByColunaFK() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( t.getVarNameCamel() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( t.getVarNameCamel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( p.getSetName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( t.getVarNameCamel() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( t.getVarNameCamel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append( t.getByColunaFK() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append( t.getByColunaFK() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( p.getSetName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append( t.getByColunaFK() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append( t.getByColunaFK() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( p.getSetName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append( t.getByColunaFK() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_150);
     if(t.isTabelaNM()){ 
    stringBuffer.append(TEXT_151);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append( t.getTabelaNM().getGetName() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append( t.getTabelaNM().getSetName() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append( p.getSetName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( t.getTabelaNM().getSetName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( p.getSetName() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( t.getTabelaNM().getNameCamel() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( t.getTabelaNM().getNameModel() );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( t.getNameModel() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( t.getTabelaNM().getSetName() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( p.getSetName() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( t.getNameCamel() );
    stringBuffer.append(TEXT_199);
    }} 
    stringBuffer.append(TEXT_200);
     if(p.hasTabelaExtends()) { 
    stringBuffer.append(TEXT_201);
     } 
    stringBuffer.append(TEXT_202);
     if(p.hasTabelaExtends()) { 
    stringBuffer.append(TEXT_203);
     } 
    stringBuffer.append(TEXT_204);
     if(p.hasTabelaExtends()) { 
    stringBuffer.append(TEXT_205);
     } 
    stringBuffer.append(TEXT_206);
    stringBuffer.append( p.getPkTypeOrArray(true) );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( (p.isArrayPk() ? "array" : "") );
    stringBuffer.append(TEXT_209);
     if(p.hasTabelaExtends()){ 
    stringBuffer.append(TEXT_210);
     } 
    stringBuffer.append(TEXT_211);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_212);
     if(!p.hasTabelaExtends()){ 
    stringBuffer.append(TEXT_213);
     } else { 
    stringBuffer.append(TEXT_214);
     } 
    stringBuffer.append(TEXT_215);
     if(!p.hasTabelaExtends()){ 
    stringBuffer.append(TEXT_216);
     } else { 
    stringBuffer.append(TEXT_217);
     } 
    stringBuffer.append(TEXT_218);
     if(!p.hasTabelaExtends()){ 
    stringBuffer.append(TEXT_219);
     } else { 
    stringBuffer.append(TEXT_220);
     } 
    stringBuffer.append(TEXT_221);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_222);
     if(!p.hasTabelaExtends()){ 
    stringBuffer.append(TEXT_223);
     } else { 
    stringBuffer.append(TEXT_224);
    stringBuffer.append( p.getTabelaExtends().getFirstPkColumn().getGetName() );
    stringBuffer.append(TEXT_225);
     } 
    stringBuffer.append(TEXT_226);
    stringBuffer.append( p.getNameModel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_228);
    if(p.hasTabelaExtends()){for (Coluna c: p.getTabelaExtends().getChavesPrimarias()) { 
    stringBuffer.append(TEXT_229);
    stringBuffer.append( c.getNameCamel() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_231);
    }}else{ 
    for (Coluna c: p.getChavesPrimarias()) { 
    stringBuffer.append(TEXT_232);
    stringBuffer.append( c.getNameCamel() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_234);
     } 
    for (Coluna c: p.getColunasFkPk()) { 
    stringBuffer.append(TEXT_235);
    stringBuffer.append( c.getTabelaFk().getVarNameCamel() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( c.getGetName() );
    stringBuffer.append(TEXT_237);
    }} 
    stringBuffer.append(TEXT_238);
    return stringBuffer.toString();
  }
}
