package lacowhile;

import java.util.Scanner;

public class LacoWhile {

	public static void main(String[] args) {
		int idade, pessoaDev, identidadeDeGenero, contaColaborador = 0, backend = 0, frontend = 0, fullStack = 0,
				mobile = 0, mulherCis = 0, mulherFront = 0, mulherTrans = 0, homemTrans = 0, homemCis = 0,
				naoBinario = 0, media, soma = 0, homemMaior = 0, homemMenor = 0, quebra = 0;
		String leitura;

		Scanner captura = new Scanner(System.in);

		System.out.println("Digite sua idade:");
		idade = captura.nextInt();
		soma += idade;
		captura.nextLine();

		System.out.println("Escolha a opção da sua identidade de gênero:");
		System.out.println("1 – Mulher Cis");
		System.out.println("2 – Homem Cis");
		System.out.println("3 – Não Binário");
		System.out.println("4 – Mulher Trans");
		System.out.println("5 – Homem Trans");
		System.out.println("6 – Outros");
		identidadeDeGenero = captura.nextInt();
		if (identidadeDeGenero > 6) {
			System.out.println("Opção inválida");
			return;
		}

		System.out.println("Digite sua categoria:");
		System.out.println("1 - Backend");
		System.out.println("2 - Frontend");
		System.out.println("3 - Mobile");
		System.out.println("4 - FullStack");
		pessoaDev = captura.nextInt();
		if (pessoaDev > 4) {
			System.out.println("Opção inválida");
			return;
		}

		contaColaborador++;

		System.out.println("Deseja continuar a leitura dos dados de um novo colaborador (S/N)?");
		captura.nextLine(); // Consumindo a quebra de linha pendente
		leitura = captura.nextLine();

		while (leitura.equalsIgnoreCase("s")) {
			System.out.println("Digite sua idade:");
			idade = captura.nextInt();
			soma += idade;
			captura.nextLine();

			System.out.println("Escolha a opção da sua identidade de gênero:");
			System.out.println("1 – Mulher Cis");
			System.out.println("2 – Homem Cis");
			System.out.println("3 – Não Binário");
			System.out.println("4 – Mulher Trans");
			System.out.println("5 – Homem Trans");
			System.out.println("6 – Outros");
			identidadeDeGenero = captura.nextInt();
			captura.nextLine();
			if (identidadeDeGenero > 6) {
				System.out.println("Opção inválida");
				continue;
			}
			System.out.println("Digite sua categoria:");
			System.out.println("1 - Backend");
			System.out.println("2 - Frontend");
			System.out.println("3 - Mobile");
			System.out.println("4 - FullStack");
			pessoaDev = captura.nextInt();
			captura.nextLine();
			if (pessoaDev > 4) {
				System.out.println("Opção inválida");
				continue;
			}

			contaColaborador++;

			System.out.println("Deseja continuar a leitura dos dados de um novo colaborador (S/N)?");
			leitura = captura.nextLine();
		}

		media = soma / contaColaborador;

		while (leitura.equalsIgnoreCase("n")) {
			quebra++;
			switch (pessoaDev) {
			case 1:
				backend++;
				break;
			case 2:
				frontend++;
				if (identidadeDeGenero == 1 || identidadeDeGenero == 4) {
					mulherFront++;
				}
				break;
			case 3:
				mobile++;
				break;
			case 4:
				fullStack++;
				switch (identidadeDeGenero) {
				case 1:
					mulherCis++;
					break;
				case 2:
					homemCis++;
					break;
				case 3:
					naoBinario++;
					break;
				case 4:
					mulherTrans++;
					break;
				case 5:
					homemTrans++;
					break;
				}
				break;
			}

			if (idade > 40 && (homemCis != 0 || homemTrans != 0) && pessoaDev == 3) {
				homemMaior++;
			}

			if (idade < 30 && naoBinario != 0 && fullStack != 0) {
				homemMenor++;
			}

			if (quebra == 1) {
				break;
			}
		}

		System.out.println("O número de pessoas desenvolvedoras Backend é: " + backend);
		System.out.println("O número de Mulheres Cis e Trans desenvolvedoras Frontend é: " + mulherFront);
		System.out.println("O número de Homens Cis e Trans desenvolvedores Mobile maiores de 40 anos é: " + homemMaior);
		System.out.println("O número de Não Binários desenvolvedores FullStack menores de 30 anos é: " + homemMenor);
		System.out.println("O número de pessoas que responderam a pesquisa foram: " + contaColaborador);
		System.out.println("A média de idade das pessoas que responderam à pesquisa é: " + media);
	}
}