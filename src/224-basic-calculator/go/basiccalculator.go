func calculate(s string) int {
    if len(s) == 0 {
		return 0
	}

	result, sign, num := 0, 1, 0

	var st []int
	st = append(st, sign)

	for i := range s {
		if s[i] >= '0' && s[i] <= '9' {
			num = num*10 + int(s[i]-'0')
		} else if s[i] == '+' || s[i] == '-' {
			result += sign * num
			sign = st[len(st)-1]
			if s[i] != '+' {
				sign *= -1
			}
			num = 0
		} else if s[i] == '(' {
			st = append(st, sign)
		} else if s[i] == ')' {
			st = st[:len(st)-1]
		}
	}

	result += sign * num
	return result
}

func calculateSecondSolution(s string) int {
	result, _ := calculateFrom(s, 0)
	return result
}

func calculateFrom(s string, idFrom int) (result, idEnd int) {
	result, currNum, sign := 0, 0, 1

	for idEnd = idFrom; idEnd < len(s) && s[idEnd] != ')'; idEnd++ {
		switch {
		case s[idEnd] >= '0':
			currNum = currNum*10 + int(s[idEnd]-'0')
		case s[idEnd] == '(':
			currNum, idEnd = calculateFrom(s, idEnd+1)
		case s[idEnd] == '-' || s[idEnd] == '+':
			result, currNum = result+currNum*sign, 0
			sign = 44 - int(s[idEnd]) // '-'=45; '+'=43
		}
	}

	return result + currNum*sign, idEnd
}