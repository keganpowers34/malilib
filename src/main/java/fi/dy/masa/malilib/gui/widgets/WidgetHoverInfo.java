package fi.dy.masa.malilib.gui.widgets;

import java.util.ArrayList;
import java.util.List;
import fi.dy.masa.malilib.render.RenderUtils;
import net.minecraft.client.resource.language.I18n;

public class WidgetHoverInfo extends WidgetBase
{
    protected final List<String> lines = new ArrayList<>();

    public WidgetHoverInfo(int x, int y, int width, int height, String key, Object... args)
    {
        super(x, y, width, height);

        this.setInfoLines(key, args);
    }

    protected void setInfoLines(String key, Object... args)
    {
        String[] split = I18n.translate(key, args).split("\\n");

        for (String str : split)
        {
            this.lines.add(str);
        }
    }

    /**
     * Adds the provided lines to the list.
     * The strings will be split into separate lines from any "\n" sequences.
     * @param lines
     */
    public void addLines(String... lines)
    {
        for (String line : lines)
        {
            line = I18n.translate(line);
            String[] split = line.split("\\n");

            for (String str : split)
            {
                this.lines.add(str);
            }
        }
    }

    public List<String> getLines()
    {
        return this.lines;
    }

    @Override
    public void render(int mouseX, int mouseY, boolean selected)
    {
    }

    @Override
    public void postRenderHovered(int mouseX, int mouseY, boolean selected)
    {
        RenderUtils.drawHoverText(mouseX, mouseY, this.lines);
    }
}
