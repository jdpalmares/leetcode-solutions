/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
    if lists == nil || len(lists) == 0 {
        return nil
    }
    
    for len(lists) > 1 {
        l1 := lists[0]
        l2 := lists[1]
        lists = lists[2:]
        
        merged := mergeTwoLists(l1, l2)
        lists = append(lists, merged)
    }
    
    return lists[0]
}

func mergeTwoLists(l1, l2 *ListNode) *ListNode {
    if l1 == nil { return l2 }
    if l2 == nil { return l1 }
    
    if l1.Val < l2.Val {
        l1.Next = mergeTwoLists(l1.Next, l2)
        return l1
    } else {
        l2.Next = mergeTwoLists(l2.Next, l1)
        return l2
    }
}

type ListNode struct {
    Val int
    Next *ListNode
}


// ANOTHER SOLUTION FASTER USING linked list slice
func mergeKLists(lists []*ListNode) *ListNode {
    return convertToList(sortNodes(convertToNodes(lists)))
}

func convertToList(nodes []*ListNode) (head *ListNode) {
    if len(nodes) == 0 {
        return nil
    }

    head = nodes[0]
    if current := head; current != nil && len(nodes) > 1 {
        for _, node := range nodes[1:] {
            current.Next, current = node, node
        }
    }
    return head
}

func sortNodes(nodes []*ListNode) []*ListNode {
    sort.Slice(nodes, func(i, j int) bool {
        return nodes[i].Val < nodes[j].Val
    })
    return nodes
}

func convertToNodes(lists []*ListNode) (nodes []*ListNode) {
    for _, list := range lists {
        nodes = append(nodes, convertNode(list)...)
    }
    return nodes
}

func convertNode(node *ListNode) (nodes []*ListNode) {
    for node != nil {
        next := node.Next
        node.Next = nil
        nodes = append(nodes, node)
        node = next
    }
    return nodes
}