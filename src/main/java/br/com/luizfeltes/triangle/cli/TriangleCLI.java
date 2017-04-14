package br.com.luizfeltes.triangle.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import br.com.luizfeltes.triangle.core.Triangle;
import br.com.luizfeltes.triangle.core.TriangleException;

/**
 * This is a Command Line Interface (CLI) to run the Triangle problem
 *
 * @author Luiz Feltes
 */
public class TriangleCLI {

    /** The command line option for help */
    private static final String OPTION_HELP = "help";
    /** The command line option for the sides */
    private static final String OPTION_SIDES = "sides";

    /**
     * Main method with the args from command line
     *
     * @param args the args from command line
     */
    public static void main(String[] args) {
        try {
            Options options = getOptions();
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption(OPTION_HELP) || cmd.getOptions().length == 0) {
                new HelpFormatter().printHelp("triangle", options);
            }
            if (cmd.hasOption(OPTION_SIDES)) {
                try {
                    System.out.println(Triangle.of(cmd.getOptionValues(OPTION_SIDES)).getType());
                } catch (TriangleException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Return the options for the command line
     *
     * @return the Options object
     */
    private static Options getOptions() {
        Options options = new Options();
        options.addOption(Option.builder(OPTION_SIDES)
                .desc("3 sides of triangle. Example: 1 1 2")
                .numberOfArgs(3)
                .build());
        options.addOption(OPTION_HELP, false, "Display help");
        return options;
    }

}
