class calc:

    #Segue-se abaixo métodos static que realizam cada um uma operação
    @staticmethod
    def soma( a, b):
        return a + b

    @staticmethod
    def sub(a, b):
        return a - b

    @staticmethod
    def mult(a, b):
        return a * b

    @staticmethod
    def div(a, b):
        if b == 0:
            return("Impossível dividir por zero!") # Retorna uma mensagem caso o denominador (b) seja zero
        else:
            return a / b

    @staticmethod
    def exp(a, b):
        return a ** b

    @staticmethod
    def mod(a):
        res = 0
        if a > 0:
            res = a
        else:
            res = -a

        return res


i = 1 #flag

print("_____CALCULADORA_____\n")

while i != 0:

    print("-------------------------\n")
    print("1. Soma\n2. Subtração\n3. Multiplicação\n4. Divisão\n5. Exponenciação\n6. Módulo\n\n")

    opt = int(input("Ecolha uma opção: "))

    #Sequência de if/else que retornam algo diferete dependendo da opção escolhida
    if opt == 6:
        a = int(input("Digite o valor: "))
        print("|{}| = {}".format(a, calc.mod(a)))
    else:
        a = int(input("Digite o primeiro valor: "))
        b = int(input("Digite o segundo valor: "))

        if opt == 1:
            print("{} + {} = {}".format(a,b,  calc.soma(a,b)))
        if opt == 2:
            print("{} - {} = {}".format(a,b,  calc.sub(a,b)))
        if opt == 3:
            print("{} x {} = {}".format(a,b,  calc.mult(a,b)))
        if opt == 4:
            print("{} / {} = {}".format(a,b,  calc.div(a,b)))
        if opt == 5:
            print("{} ^ {} = {}".format(a,b,  calc.exp(a,b)))

    #variável que receberá um de dois possíveis valores (1 ou 0) para decidir se o loop continua
    i = int(input("\nDeseja realizar mais um cálculo?\n1. Sim | 0. Não\n"))
    print()
    if i == 0:
        print("Encerrando programa...")