package dados.carros.repositorios;

import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Interfaces.IRepositorioCarro;
import dados.carros.Carro;

public class RepositorioCarroArquivo implements IRepositorioCarro{

	private FileOutputStream excel;
	private Sheet sheetExcel;

	// TODO: Fazer checagem se o arquivo ja existe para poder persistir
	public RepositorioCarroArquivo(){

		// cria planilha
		Workbook wb = new HSSFWorkbook();
		// planilha
		sheetExcel = wb.createSheet();
		Row row = sheetExcel.createRow(0);

		String array[] = {" Modelo "," Marca "," Potencia "," Porta "," Categoria "," Valor "," Ar "," Travas "," Airbag "," GPS "," Som ","Dire��o Hid.", "Freios ABS"};
		for (int i = 0; i < array.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(array[i]);
		}


		try{
			this.excel  = new FileOutputStream("Repositorio Carro.xls");
			wb.write(excel);
			excel.close();	


		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public void inserirCarro(Carro carro) {
		// Roda as linhas e insere o valor devido
		for (int i = 0; i < sheetExcel.getRow(0).getHeight(); i++) {
			Row row = sheetExcel.getRow(0);
			Cell cell = row.getCell(i);
		   //    RESOLVER O PROBLEMA DO TESTE SE A LINHA � NULA .
			
					
				int count = 1;
				String palavraBase = cell.getStringCellValue() ;
				
				if(palavraBase.equals("Modelo")){
					Row rowInserir = sheetExcel.getRow(count);
					Cell cellInserir = rowInserir.getCell(1);
					
					cell.setCellValue(carro.getModelo());
					
				}else if(palavraBase.equals("Marca")){
					if(row == null)
					cell.setCellValue(carro.getModelo());
					
				}else if(palavraBase.equals("Potencia")){
					cell.setCellValue(carro.getPotencia());
					
				}else if(palavraBase.equals("Porta")){
					cell.setCellValue(carro.getPorta());
				
				}else if (palavraBase.equals("Categoria")){
					cell.setCellValue(carro.getCategoria());
					
				}else if(palavraBase.equals("Valor")){
					cell.setCellValue(carro.getValor());
					
				}else if(palavraBase.equals("Ar")){
					cell.setCellValue(carro.getAdicionais().isAr());
					
				}else if(palavraBase.equals("Travas")){
					cell.setCellValue(carro.getAdicionais().isTravasEletricas());
					
				}else if(palavraBase.equals("Airbag")){
					cell.setCellValue(carro.getAdicionais().isAirbag());
					
				}else if(palavraBase.equals("GPS")){
					cell.setCellValue(carro.getAdicionais().isGps());
					
				}else if(palavraBase.equals("Som")){
					cell.setCellValue(carro.getAdicionais().isSom());
					
				}else if (palavraBase.equals("Dire��o Hid.")){
					cell.setCellValue(carro.getAdicionais().isDirHidraulica());
					
				}else {
					cell.setCellValue(carro.getAdicionais().isFreioABS());
					
				}

		}


	}

	public void removerCarro(String modelo) {
		
	}


	public void atualizar(Carro carro) {
		
	}

	public Carro pesquisarCarro(String modelo) {

		for (int i = 0; i < 9; i++) {
			Row celula = this.sheetExcel.getRow(i);


		}


		return null;
	}


}
