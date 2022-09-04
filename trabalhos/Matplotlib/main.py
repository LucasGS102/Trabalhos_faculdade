import matplotlib.pyplot as plt

# RU 3679902 a = 9, b = 3 e c = 2
# y = 9x + 3x -2
# x = 5, x = 7, x = 9

x1 = 5
x2 = 7
x3 = 9

y1 = 9*x1 + 3*x1 - 2
y2 = 9*x2 + 3*x2 - 2
y3 = 9*x3 + 3*x3 - 2

#Usa a função plot que recebe duas listas, uma para x e outra para y
# 'bo' é referente a cor (azul) e o tipo (pontos)
plt.plot([x1, x2, x3], [y1, y2, y3], 'bo')
plt.xlabel('Eixo das abscissas')
plt.ylabel('Eixo das ordenadas')
plt.legend(['f(x) = 9x + 3x - 2'])
plt.show()
