package dados.carros.repositorios;

import interfaces.IRepositorioCarro;
import interfaces.Iterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dados.carros.Adicionais;
import dados.carros.Carro;
import dados.pessoas.Cliente;
import exceptions.BIException;

public class ArquivoCarro implements IRepositorioCarro, Iterator {

	private FileOutputStream fos;
	private FileInputStream fis;
	private Sheet sheetExcel;
	private Workbook wb;
	private int count;

	// TODO: Fazer checagem se o arquivo ja existe para poder persistir
	public ArquivoCarro() {

		count = 1;
		if (!new File("RepositorioCarro.xls").exists()) {
			// cria planilha
			wb = new HSSFWorkbook();
			// planilha
			sheetExcel = wb.createSheet();
			Row row = sheetExcel.createRow(0);

			String array[] = { "Placa ", " Modelo ", " Marca ", " Potencia ",
					" Porta ", " Categoria ", " Valor ", " Ar ", " Travas ",
					" Airbag ", " GPS ", " Som ", "Dire��o Hid.", "Freios ABS",
					"Disponibilidade", " Data de Entrega", "Data de Saida" };
			for (int i = 0; i < array.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(array[i]);
			}

			try {
				this.fos = new FileOutputStream("RepositorioCarro.xls");
				wb.write(fos);
				fos.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			abrirRepositorio();
		}
	}

	private void abrirRepositorio() {
		try {
			this.fis = new FileInputStream("RepositorioCarro.xls");
			wb = new HSSFWorkbook(fis);
			fis.close();
		} catch (IOException e) {

		}
	}

	public void inserirCarro(Carro carro) {
		// abrirRepositorio();
		int count = 0;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		// verifica se existe um espa�o em null entre as linhas da planilha
		while (count <= ultimaLinha && !achou) {

			if (wb.getSheetAt(0).getRow(count) == null) {
				Row newRow = wb.getSheetAt(0).createRow(count);
				this.createRow(newRow, carro);
				achou = true;

			} else if (count == ultimaLinha) {
				Row newRow = wb.getSheetAt(0).createRow(
						wb.getSheetAt(0).getLastRowNum() + 1);
				this.createRow(newRow, carro);
				achou = true;
			}
			count++;
		}

		try {
			this.fos = new FileOutputStream("RepositorioCarro.xls");
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removerCarro(String placa) {
		abrirRepositorio();
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();

		while (count < ultimaLinha && !achou) {

			if (wb.getSheetAt(0).getRow(count) == null) {
				count++;
			}

			String placaAtual = wb.getSheetAt(0).getRow(count).getCell(0)
					.getStringCellValue();
			if (placaAtual.equals(placa)) {
				Row row = wb.getSheetAt(0).getRow(count);
				wb.getSheetAt(0).removeRow(row);
				achou = true;
			} else {
				count++;
			}

		}
		try {
			this.fos = new FileOutputStream("RepositorioCarro.xls");
			wb.write(fos);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Carro carro) {

		String placaCarro = carro.getPlaca();
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();

		while (count < ultimaLinha && !achou) {

			if (wb.getSheetAt(0).getRow(count).getCell(0).equals(placaCarro)) {
				Row selectedRow = wb.getSheetAt(0).getRow(count);
				wb.getSheetAt(0).removeRow(selectedRow);
				this.createRow(selectedRow, carro);
			} else {
				count++;
			}
		}

	}

	public Carro pesquisarCarro(String placa) throws BIException {

		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		Carro carroPesquisado = null;

		while (count < ultimaLinha && !achou) {

			if (wb.getSheetAt(0).getRow(count).getCell(0).equals(placa)) {
				Row posicao = wb.getSheetAt(0).getRow(count);
				carroPesquisado = createCarro(posicao);
				achou = true;
			} else {
				count++;
			}
		}
		if (!achou) {
			throw new BIException();
		}
		return carroPesquisado;
	}

	public Carro createCarro(Row posicao) {

		Adicionais adicionais = new Adicionais(
				(boolean)posicao.getCell(7).getBooleanCellValue(),
				(boolean)posicao.getCell(10).getBooleanCellValue(),
				(boolean)posicao.getCell(8).getBooleanCellValue(),
				(boolean)posicao.getCell(11).getBooleanCellValue(),
				(boolean)posicao.getCell(13).getBooleanCellValue(), 
				(boolean)posicao.getCell(9).getBooleanCellValue(),
				(boolean)posicao.getCell(12).getBooleanCellValue());
		// new Carro(placa, porta, potencia, modelo, marca, categoria,adicionais, valor)
		// return new Carro(
		return new Carro(posicao.getCell(0).getStringCellValue(), (int) posicao
				.getCell(4).getNumericCellValue(), posicao.getCell(3)
				.getStringCellValue(), posicao.getCell(1).getStringCellValue(),
				posicao.getCell(2).getStringCellValue(), posicao.getCell(5)
						.getStringCellValue(), adicionais, (double) posicao
						.getCell(6).getNumericCellValue());
	}

	@SuppressWarnings("deprecation")
	private void createRow(Row selectedRow, Carro carro) {
		Row row = selectedRow;
		Row row1 = wb.getSheetAt(0).getRow(0);

		for (int j = 0; j < 17; j++) {
			Cell cell = row1.getCell(j);
			Cell cellInserir = row.createCell(j);

			String palavraBase = cell.getStringCellValue();

			if (palavraBase.contains("Placa")) {
				cellInserir.setCellValue(carro.getPlaca());
			} else if (palavraBase.contains("Modelo")) {

				cellInserir.setCellValue(carro.getModelo());

			} else if (palavraBase.contains("Marca")) {

				cellInserir.setCellValue(carro.getMarca());

			} else if (palavraBase.contains("Potencia")) {
				cellInserir.setCellValue(carro.getPotencia());

			} else if (palavraBase.contains("Porta")) {
				cellInserir.setCellValue(carro.getPorta());

			} else if (palavraBase.contains("Categoria")) {
				cellInserir.setCellValue(carro.getCategoria());

			} else if (palavraBase.contains("Valor")) {
				cellInserir.setCellValue(carro.getValor());

			} else if (palavraBase.contains("Ar")) {
				cellInserir.setCellValue(carro.getAdicionais().isAr());

			} else if (palavraBase.contains("Travas")) {
				cellInserir.setCellValue(carro.getAdicionais()
						.isTravasEletricas());

			} else if (palavraBase.contains("Airbag")) {
				cellInserir.setCellValue(carro.getAdicionais().isAirbag());

			} else if (palavraBase.contains("GPS")) {
				cellInserir.setCellValue(carro.getAdicionais().isGps());

			} else if (palavraBase.contains("Som")) {
				cellInserir.setCellValue(carro.getAdicionais().isSom());

			} else if (palavraBase.contains("Dire��o Hid.")) {
				cellInserir.setCellValue(carro.getAdicionais()
						.isDirHidraulica());

			} else if (palavraBase.contains("Freios ABS")) {
				cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

			} else if (palavraBase.contains("Disponibilidade")) {
				cellInserir.setCellValue(carro.isDisponibilidade());

			} else if (palavraBase.contains("Data de Entrega")) {
				Date dataEntrega = carro.getDataEntrega();
				if (dataEntrega != null) {
					cellInserir.setCellValue(dataEntrega.toLocaleString());
				} else {
					cellInserir.setCellValue("");
				}

			} else {
				Date dataSaida = carro.getDataSaida();
				if (dataSaida != null) {
					cellInserir.setCellValue(dataSaida.toLocaleString());
				} else {
					cellInserir.setCellValue("");
				}
			}
		}
	}

	@Override
	public Carro next() {
		count++;
		Row posicao = wb.getSheetAt(0).getRow(this.count - 1);
		return createCarro(posicao);
	}

	@Override
	public boolean hasNext() {
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		if (count < ultimaLinha)
			return true;
		else
			return false;

	}

	@Override
	public Iterator iterator() {
		return this;
	}
}
