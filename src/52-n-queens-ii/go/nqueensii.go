func totalNQueens(n int) int { // backtracking solution
    col := make([]int, n)
	diag := make([]int, n*2)
	diag2 := make([]int, n*2)
	var count int
	var search func(y int)
	search = func(y int) {
		if y == n {
			count++
			return
		}

		for x := 0; x < n; x++ {
			if col[x] != 0 || diag[x+y] != 0 || diag2[x-y+n-1] != 0 {
				continue
			}
			col[x], diag[x+y], diag2[x-y+n-1] = 1, 1, 1
			search(y + 1)
			col[x], diag[x+y], diag2[x-y+n-1] = 0, 0, 0
		}
	}

	search(0)
	return count
}

func totalNQueensBitManip(n int) int { //bit manipulation solution
    leftDiagMap := 0
	rightDiagMap := 0
	colMap := 0

	var placeQueens func(int) int
	placeQueens = func(row int) int {
		if row >= n {
			return 1
		}

		result := 0
		for col := 0; col < n; col++ {
			leftDiagShift := row + col
			rightDiagShift := n + (row - col)

            if (colMap & (1 << col)) != 0 ||
				(leftDiagMap & (1 << leftDiagShift)) != 0 ||
				(rightDiagMap & (1 << rightDiagShift)) != 0 {
				continue
			}

			colMap |= 1 << col
			leftDiagMap |= 1 << leftDiagShift
			rightDiagMap |= 1 << rightDiagShift

			result += placeQueens(row + 1)

			colMap &= ^(1 << col)
			leftDiagMap &= ^(1 << leftDiagShift)
			rightDiagMap &= ^(1 << rightDiagShift)
		}

		return result
	}

	return placeQueens(0)
}