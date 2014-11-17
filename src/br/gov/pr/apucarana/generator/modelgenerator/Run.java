package br.gov.pr.apucarana.generator.modelgenerator;

import java.util.HashMap;
import java.util.Map.Entry;

public class Run {

	public static void main(String[] args) {
		try {
			HashMap<String, String> hash = new HashMap<String, String>();
			/*
			 * hash.put("tb_acesso_rapido", "sitepma"); hash.put("tb_auditoria",
			 * "sitepma"); hash.put("tb_agenda", "sitepma");
			 * hash.put("tb_banner", "sitepma"); hash.put("tb_banner_pos",
			 * "sitepma"); hash.put("tb_comentarios", "sitepma");
			 * hash.put("tb_enquete", "sitepma"); hash.put("tb_gabinete",
			 * "sitepma"); hash.put("tb_mais_informacoes", "sitepma");
			 * hash.put("tb_menu", "sitepma"); hash.put("tb_modulo", "sitepma");
			 * hash.put("tb_modulo_classificacao", "sitepma");
			 * hash.put("tb_modulo_video", "sitepma"); hash.put("tb_multifotos",
			 * "sitepma"); hash.put("tb_multifotos_chamadas", "sitepma");
			 * hash.put("tb_multinotas", "sitepma"); hash.put("tb_noticia",
			 * "sitepma"); hash.put("tb_noticia_audios", "sitepma");
			 * hash.put("tb_noticia_estado", "sitepma");
			 * hash.put("tb_noticia_fotos", "sitepma");
			 * hash.put("tb_noticia_pos", "sitepma");
			 * hash.put("tb_noticia_videos", "sitepma"); hash.put("tb_online",
			 * "sitepma"); hash.put("tb_opcoes", "sitepma");
			 * hash.put("tb_ouvidoria", "sitepma");
			 * hash.put("tb_ouvidoria_tipo", "sitepma");
			 * hash.put("tb_representante", "sitepma");
			 * hash.put("tb_representante_titulo", "sitepma");
			 * hash.put("tb_secretaria", "sitepma");
			 * hash.put("tb_secretaria_classificacao", "sitepma");
			 * hash.put("tb_site", "sitepma"); hash.put("tb_sub_modulo",
			 * "sitepma"); hash.put("tb_sub_modulo_imagens", "sitepma");
			 * hash.put("tb_sub_modulo_videos", "sitepma");
			 * hash.put("tb_transmissoes", "sitepma"); hash.put("tb_video",
			 * "sitepma"); hash.put("vw_busca", "sitepma");
			 * 
			 * hash.put("tb_transporte_ano", "sitepma_transporte");
			 * hash.put("tb_transporte_area", "sitepma_transporte");
			 * hash.put("tb_transporte_comprovante_residencia_tipo",
			 * "sitepma_transporte"); hash.put("tb_transporte_escola",
			 * "sitepma_transporte"); hash.put("tb_transporte_escola_tipo",
			 * "sitepma_transporte"); hash.put("tb_transporte_controle_val",
			 * "sitepma_transporte"); hash.put("tb_transporte_estado",
			 * "sitepma_transporte"); hash.put("tb_transporte_grau_parentesco",
			 * "sitepma_transporte"); hash.put("tb_transporte_opcao",
			 * "sitepma_transporte"); hash.put("tb_transporte_periodo",
			 * "sitepma_transporte"); hash.put("tb_transporte_serie",
			 * "sitepma_transporte"); hash.put("tb_transporte_tipo_curso",
			 * "sitepma_transporte"); hash.put("tb_transporte_tipo_usuario",
			 * "sitepma_transporte"); hash.put("tb_transporte_usuario",
			 * "sitepma_transporte"); hash.put("tb_transporte_cancelamento",
			 * "sitepma_transporte");
			 */

			/*
			 * hash.put("tb_inscritos_20101", "sitepma_inscricoes_2010");
			 * hash.put("tb_cargo_20101", "sitepma_inscricoes_2010");
			 * hash.put("tb_cargo_20101", "sitepma_inscricoes_2010");
			 * hash.put("tb_inscricao_corrida_contra_cancer",
			 * "sitepma_inscricoes_2010");
			 * hash.put("tb_encontro_nasf_inscricao",
			 * "sitepma_inscricoes_2010"); hash.put("tb_encontro_nasf_oficina",
			 * "sitepma_inscricoes_2010");
			 */
			

			/*hash.put("tb_suaideiatemvalor_votacao", "sitepma_inscricoes_2010");
			hash.put("tb_suaideiatemvalor_ideia", "sitepma_inscricoes_2010");*/
			hash.put("tb_funcapfestival", "sitepma_inscricoes_2010");
			/*hash.put("tb_seminario_integral_grupo", "sitepma_inscricoes_2010");
			hash.put("tb_seminario_integral_oficina", "sitepma_inscricoes_2010");			
			hash.put("tb_corrida28", "sitepma_inscricoes_2010");
			hash.put("tb_corrida28_categoria", "sitepma_inscricoes_2010");*/
			
			/*
			 * hash.put("tb_estado", "sitepma_util");
			 * hash.put("tb_estado_cidade", "sitepma_util");
			 * hash.put("tb_previsao_cptec", "sitepma_util");
			 * hash.put("tb_app_vars", "sitepma_util");
			 * hash.put("tb_estado_civil", "sitepma_util");
			 * 
			 * hash.put("tb_seg_funcao", "sitepma_segur");
			 * hash.put("tb_seg_grupo", "sitepma_segur");
			 * hash.put("tb_seg_grupo_funcao", "sitepma_segur");
			 * hash.put("tb_seg_grupo_usuario", "sitepma_segur");
			 * hash.put("tb_seg_usuario", "sitepma_segur");
			 */

			for (Entry<String, String> entry : hash.entrySet()) {
				Generator generator = new Generator(
						"C:/models", entry
								.getKey()/* Tabela */, entry.getValue()/* Banco */);
				generator.gerarTudo();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}