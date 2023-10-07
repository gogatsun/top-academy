package org.top.applicationsquare.service;

import org.springframework.stereotype.Service;
import org.top.applicationsquare.message.InputMessage;
import org.top.applicationsquare.message.OutputMessage;

@Service
public interface Solver {
    OutputMessage solve(InputMessage input);
}
