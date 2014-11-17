package br.gov.pr.apucarana.generator.modelgenerator.templates;

import br.gov.pr.apucarana.generator.modelgenerator.bean.Parametros;

public class GatewayTemplate {
  protected static String nl;
  public static synchronized GatewayTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    GatewayTemplate result = new GatewayTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?php" + NL + "" + NL + "/**" + NL + " * Gateway de dados da tabela ";
  protected final String TEXT_2 = NL + " * " + NL + " * @uses       Zend_Db_Table_Abstract" + NL + " * @subpackage Model" + NL + " */" + NL + "class ";
  protected final String TEXT_3 = " extends Zend_Db_Table_Abstract{" + NL + "" + NL + "    /**" + NL + "     * @var string do banco de dados" + NL + "     */" + NL + "\tprotected $_schema = \"";
  protected final String TEXT_4 = "\";" + NL + "    " + NL + "    /**" + NL + "     * @var string nome da tabela no banco de dados" + NL + "     */" + NL + "    protected $_name = \"";
  protected final String TEXT_5 = "\";" + NL + "    ";
  protected final String TEXT_6 = NL + "    /**" + NL + "     * @var ";
  protected final String TEXT_7 = " correspondente a PK da tabela" + NL + "     */" + NL + "    protected $_primary = ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "}";

	public String generate(Parametros p)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append( p.getNameCamel() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( p.getNameGateway() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( p.getNameBanco() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( p.getName() );
    stringBuffer.append(TEXT_5);
     if(p.isPossuidoraPk()) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append( p.getPkTypeOrArray() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( p.getPkNmOrArrayPkNm() );
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
