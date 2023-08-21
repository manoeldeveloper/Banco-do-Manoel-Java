package com.java.banco.mano;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
	
		 static Scanner leia = new Scanner(System.in);
		 static ArrayList<Conta> contasBancarias;
		
		public static void main(String[] args) {
			contasBancarias = new ArrayList<Conta>();
			menu();
		}		 			 			 
		 
		public static void menu() {
		    try {
		        boolean verificador = false;

		        do {
		            System.out.println("------------------------------------------------------");
		            System.out.println("-------------BEM VINDO AO BANCO DO MANO---------------");
		            System.out.println("------------------------------------------------------");
		            System.out.println("***** Selecione uma operação que deseja realizar *****");
		            System.out.println("------------------------------------------------------");
		            System.out.println("|   Opção 1 - Criar conta   |");
		            System.out.println("|   Opção 2 - Depositar     |");
		            System.out.println("|   Opção 3 - Sacar         |");
		            System.out.println("|   Opção 4 - Transferir    |");
		            System.out.println("|   Opção 5 - Listar        |");
		            System.out.println("|   Opção 6 - Sair          |");

		            int opt = 0;
		            boolean inputValido = false;
		            do {
		                try {
		                    opt = leia.nextInt();
		                    inputValido = true;
		                } catch (Exception e) {
		                    System.out.println("Entrada inválida! Digite um número válido.");
		                    leia.nextLine(); // Limpa o buffer do scanner
		                }
		            } while (!inputValido);

		            switch (opt) {
		                case 1:
		                    criarConta();
		                    verificador = true;
		                    break;
		                case 2:
		                    depositar();
		                    verificador = true;
		                    break;
		                case 3:
		                    sacar();
		                    verificador = true;
		                    break;
		                case 4:
		                    transferir();
		                    verificador = true;
		                    break;
		                case 5:
		                    listar();
		                    verificador = true;
		                    break;
		                case 6:
		                    System.out.println("Obrigado por usar nosso sistema!\nAté a próxima!");
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("Escolha uma das opções!");
		                    break;
		            }
		        } while (!verificador);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		 
          
          public static void criarConta() {
        	  System.out.println("Você está criando uma conta!\n");
        	  
        	  System.out.println("Nome: ");
        	  String nome = leia.next();
        	  
        	  System.out.println("CPF: ");
        	  String cpf = leia.next();
        	  
        	  System.out.println("Sexo: ");
        	  String sexo = leia.next();
        	  
        	  Pessoa cliente = new Pessoa(nome,sexo,cpf);
        	  
        	  Conta conta = new Conta(cliente);
        	  
        	  contasBancarias.add(conta);
        	  
        	  System.out.println("Sua conta foi criada com sucesso!");
        	  
        	  menu();
          }
          
          protected static Conta encontrarConta(int numConta) {
        	  Conta conta = null;
        	  if(contasBancarias.size() > 0) {
        		  for(Conta c : contasBancarias) {
        			  if(c.getNumeroConta() == numConta) {
        				  conta = c;
        				  System.out.println("Seu Saldo Atual: " + conta.getSaldo() + "\n");
        			  }
        		  }
        	  }
        	  return conta;
          }
          
          public static void depositar() {
        	  
        	  System.out.println("Número da Conta desejada: ");
        	  int num = leia.nextInt();
        	  
        	  Conta conta = encontrarConta(num);
        	  
        	  if(conta != null) {
        		  System.out.println("Qual o valor que deseja depositar: ");
        		  double valor = leia.nextDouble();
        		  
        		  conta.depositar(valor);
        		  
        	  } else {
        		  System.out.println("Verifique o valor!");
        	  }
        	  
        	  menu();
          }

          public static void sacar() {
        	  System.out.println("Número da Conta desejada: ");
        	  int num = leia.nextInt();
        	  
        	  Conta conta =  encontrarConta(num);
        	  
        	  if(conta != null) {
        		  System.out.println("Qual valor desejado para saque?");
        		  double valor = leia.nextDouble();
        		  
        		  conta.sacar(valor);
        	  } else {
        		  System.out.println("Verique o valor!");
        	  }
        	  menu();
          }
          public static void transferir() {
        	  System.out.println("Número da conta que vai enviar a transferência: ");
              int numeroContaRemetente = leia.nextInt();

              Conta contaRemetente = encontrarConta(numeroContaRemetente);

              if(contaRemetente != null) {
                  System.out.println("Número da conta do destinatário: ");
                  int numeroContaDestinatario = leia.nextInt();

                  Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

                  if(contaDestinatario != null) {
                      System.out.println("Valor da transferência: ");
                      Double valor = leia.nextDouble();

                      contaRemetente.transferir(contaDestinatario, valor);

                  }else {
                      System.out.println("A conta para depósito não foi encontrada");
                  }

              }else {
                  System.out.println("Conta para transferência não encontrada");
              }
              menu();
          }
          public static void listar() {
        	  if(contasBancarias.size() > 0) {
        		  for(Conta c : contasBancarias) {
        			  System.out.println(c);
        		  } {
        		  }
        	  } else {
    			  System.out.println("Não há contas!");

        	  }
        	  menu();
          }
          
          }
		

