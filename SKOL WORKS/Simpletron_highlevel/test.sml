    jmp start
    a
    b
    c
start:
    Read a
    Read b
    Read c
    LoadM a
    SubM c
    JZ end
again:
    Write a
    LoadM a
    SubM b
    JZ end
    Store a
    jmp again
end:
    Halt
